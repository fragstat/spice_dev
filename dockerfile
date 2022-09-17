FROM eclipse-temurin:17-jdk-focal

WORKDIR /app
EXPOSE 8081

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnx", "spring-boot:run"]