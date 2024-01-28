package com.eyecode.config;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration 
@EnableWebSecurity
public class SpringSecurityConfig {	
	
	@Autowired
	UserDetailsService  userDetailsService;
	
	/*
	@Bean
	InMemoryUserDetailsManager detailsManager() {
		
	    UserDetails user = org.springframework.security.core.userdetails.User.withUsername("Cristian")
	    	      .password(passwordEncoder().encode("password"))
	    	      .roles("USER","ADMIN")
	    	      .build();
	    	    return new InMemoryUserDetailsManager(user);
	}*/
	
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      

		http
			.csrf( csrf -> csrf.disable() )
       		.authorizeHttpRequests((authorize) -> authorize	
                .requestMatchers("/usuarios/**")
                .hasRole("ADMIN")
                .requestMatchers("/cursos/*")
                .hasAnyRole("ADMIN","USER")
                .anyRequest()
                .permitAll()
          )
       		.formLogin(Customizer.withDefaults())  
       		.logout( logout -> logout.logoutRequestMatcher( new AntPathRequestMatcher("/logout") ).permitAll() );  
			
    	
    	
        return http.build();
    }
	
	@Autowired
	private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	private static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
