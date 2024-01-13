package com.eyecode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eyecode.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
