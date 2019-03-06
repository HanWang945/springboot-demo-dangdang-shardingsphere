FROM java:8
COPY ./target/springboot-demo*.jar /opt/springboot-demo-1.0.jar
ENTRYPOINT ["java","-jar","/opt/springboot-demo-1.0.jar"]