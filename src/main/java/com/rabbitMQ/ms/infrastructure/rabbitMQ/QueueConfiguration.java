package com.rabbitMQ.ms.infrastructure.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

    @Bean
    public Queue productsQueue() {
        return new Queue("products");
    }

    @Bean
    public Queue dispachQueue() {
        return new Queue("products.dispatch");
    }
}
