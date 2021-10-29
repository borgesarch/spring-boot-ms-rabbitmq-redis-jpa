

<img src="https://cdn.freelogovectors.net/wp-content/uploads/2021/02/rabbitmq-logo-freelogovectors.net_-768x123.png" width="280"><img src="https://th.bing.com/th/id/R.c70998c09711ec9cc6b373d5427b4f3f?rik=J%2f8td1sh8%2bf7cw&pid=ImgRaw&r=0" width="200"><img src="https://atomrace.com/blog/wp-content/uploads/2018/05/spring-boot-logo.png" width="150">




# Spring Boot RabbitMQ, Redis e Spring JPA.
Solução simples para comunicação de serviços via RabbitMQ e melhorando a performance com Redis para cachegamento.



# #

[![License](https://img.shields.io/badge/License-MIT-silver.svg?style=flat)](https://github.com/clips/pattern/blob/master/LICENSE.txt) 
[![License](https://img.shields.io/badge/SpringBoot-2.6.0RC1-green.svg?style=flat)](https://github.com/clips/pattern/blob/master/LICENSE.txt) 
[![License](https://img.shields.io/badge/RabbitMQ-3.6-orange.svg?style=flat)](https://github.com/clips/pattern/blob/master/LICENSE.txt) 
[![License](https://img.shields.io/badge/Redis-2.6.3-red.svg?style=flat)](https://github.com/clips/pattern/blob/master/LICENSE.txt) 

##


Deployment in one command
```sh
$ sudo docker-compuse up --build
```

```sh
$ gradle bootRun
```

Enviar mensagem via test:

```sh
$ gradle test
```

Result:

```sh

2021-10-29 17:05:56.986  INFO 11280 --- [ntContainer#1-1] c.r.m.i.r.listeners.PaymentListener      : 0c9b3d13-ddbc-485b-a386-7d465c20b8a1
2021-10-29 17:05:56.986  INFO 11280 --- [ntContainer#1-1] c.r.m.i.r.listeners.PaymentListener      : approved
2021-10-29 17:05:56.986  INFO 11280 --- [ntContainer#1-1] c.r.m.i.r.listeners.PaymentListener      : 1
2021-10-29 17:06:04.166  INFO 11280 --- [ntContainer#0-1] c.r.m.i.r.listeners.DispachListener      : Pedido: 485854: enviado

```


OpenAPI:

```sh
curl --request GET \
  --url http://localhost:8001/swagger-ui/index.html
```

<img src="https://github.com/borgesdeveloper/spring-boot-ms-rabbitmq-redis-jpa/blob/main/src/main/resources/static/open-api.png" width="1000">
