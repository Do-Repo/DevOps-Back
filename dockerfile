FROM openjdk:11
WORKDIR /app
EXPOSE 80
RUN curl -u admin:nexus -O 
ADD target/timesheet-devops-1.0.jar timesheet-devops-1.0.jar
ENTRYPOINT ["java","-jar","/timesheet-devops-1.0.jar"]

