# spring-boot-tempo-demo
基于grafana tempo进行的一个spring boot项目的demo

###1.安装插件
```shell
 docker plugin install grafana/loki-docker-driver:latest --alias loki --grant-all-permissions
```

###2.启动服务
```shell
chmod +x docker-setup.sh && ./docker-setup.sh
```

###3.发送请求
```shell
curl http://localhost:9902/order/47289104535674566
```

###4.打开网站 http:localhost:3000,进行日志查询