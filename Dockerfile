FROM openjdk:17-alpine
LABEL maintainer="ahmismail.c@stc.com.sa"
WORKDIR /usr/local/bin/
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-1.0.jar
EXPOSE 8888
CMD ["java","-jar","service-1.0.jar"]
ENTRYPOINT ["java","-jar","service-1.0.jar"]
