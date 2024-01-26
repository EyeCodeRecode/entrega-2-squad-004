# Estágio de construção (build)
FROM ubuntu:latest AS build

RUN apt-get update \
    && apt-get install -y openjdk-17-jdk maven \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copia apenas os arquivos necessários para otimizar o cache
COPY pom.xml .
COPY src ./src

# Constrói o projeto sem executar os testes
RUN mvn clean install -DskipTests

# Estágio de produção
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

# Copia o JAR construído a partir do estágio de construção
COPY --from=build /app/target/entrega-2-squad-004-1.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
