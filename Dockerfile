FROM openjdk:17-jdk-alpine
EXPOSE 8089

# Install wget if not already present
RUN apk add --no-cache wget

# Download the JAR file using Nexus credentials
RUN wget --no-verbose \
    --user=admin \
    --password=admin \
    -O tp-foyer-5.0.1.jar \
    http://192.168.50.4:8081/repository/maven-releases/tn/esprit/tp-foyer/5.0.1/tp-foyer-5.0.1.jar

ENTRYPOINT ["java", "-jar", "/tp-foyer-5.0.1.jar"]