# PROMETHEUS MONITORING

Download the prometheus docker instance using following command-

```sh
docker run -p 9090:9090 -d \
-v /Users/sombose/Learning/prometheus.yml:/etc/prometheus/prometheus.yml \
prom/prometheus
```

To veerify prometheus is scraping the data, Run this command.

```sh
{instance="localhost:8080",job="prometheus-spring-app"}
```

You will see output like this 
![screenshot_1](https://github.com/Someshbose/grafana-spring-app/blob/master/images/Screenshot_1.png)

Copy the ip running following command-
```sh
docker inspect <instance-id>
```

Run grafana docker instance and create a panel with following query

```sh
docker run -v -d -p 3000:3000 grafana/grafana
```

You will see the ouput like this-

![screenshot2](https://github.com/Someshbose/grafana-spring-app/blob/master/images/Screenshot_2.png)


###Reference

https://dzone.com/articles/spring-boot-monitoring-via-prometheus-grafana
