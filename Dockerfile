FROM openjdk:11.0-jre-slim
EXPOSE 8085
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} srv-neg-security-authentication-v1.jar
ENTRYPOINT ["java","-jar","/srv-neg-security-authentication-v1.jar"]