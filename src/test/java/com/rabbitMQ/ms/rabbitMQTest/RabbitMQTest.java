package com.rabbitMQ.ms.rabbitMQTest;


import com.rabbitMQ.ms.domain.aggregates.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RabbitMQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void sendMessage() {

        Payment payment = new Payment();
        payment.setId(UUID.randomUUID().toString());
        payment.setProduct_id(1);
        payment.setOrder_id(485854);
        payment.setStatus("approved");
        rabbitTemplate.convertAndSend("products", payment);

        assertEquals("", "");
    }
}
