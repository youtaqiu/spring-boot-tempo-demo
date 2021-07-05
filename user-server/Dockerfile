FROM youtaqiu/jre
COPY ./target/user-server.jar /app.jar
COPY ./opentelemetry-javaagent-all.jar /javaagent-all.jar
ENV TZ=Asia/Shanghai
EXPOSE 9901
CMD ["java","-Dotel.instrumentation.methods.include=me.youm.demo.tempo.order.domain[setOrderNo]", "-javaagent:/javaagent-all.jar",  "-jar", "/app.jar"]