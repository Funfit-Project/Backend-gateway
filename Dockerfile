FROM openjdk:17

ARG JAR_FILE=/build/libs/*.jar

COPY ${JAR_FILE} funfit_gateway.jar

ENTRYPOINT ["java","-jar","funfit_gateway.jar"]
