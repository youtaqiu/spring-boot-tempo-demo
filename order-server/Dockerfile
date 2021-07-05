FROM youtaqiu/jre
COPY ./target/order-server.jar /app.jar
COPY ./opentelemetry-javaagent-all.jar /javaagent-all.jar
ENV TZ=Asia/Shanghai
EXPOSE 9901
CMD ["java", "-javaagent:/javaagent-all.jar",  "-jar", "/app.jar"]