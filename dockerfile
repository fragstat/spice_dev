FROM eclipse-temurin:17-jdk-focal

EXPOSE 8081

MAINTAINER serh_valavin
COPY target/spice-*.jar spice.jar
ENTRYPOINT ["java","-jar","/spice.jar"]