FROM eclipse-temurin:17-jdk

EXPOSE 8080

# COPY is preferred over ADD for a local file
COPY target/springboot-docker-kubernetes.jar /springboot-docker-kubernetes.jar

ENTRYPOINT [ "java", "-jar", "/springboot-docker-kubernetes.jar" ]

