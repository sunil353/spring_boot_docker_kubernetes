FROM eclipse-temurin:17-jdk

EXPOSE 8080

ADD target/springboot-docker-kubernetes.jar /springboot-docker-kubernetes.jar

ENTRYPOINT [ "java", "-jar", "/springboot-docker-kubernetes.jar" ]

