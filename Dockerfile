FROM eclipse-temurin:17-jdk

EXPOSE 8080

ADD ./target/springboot-docker-kubernetes.jar /springboot-docker-kubernetes.jar

CMD [ "java", "-jar", "springboot-docker-kubernetes.jar" ]


