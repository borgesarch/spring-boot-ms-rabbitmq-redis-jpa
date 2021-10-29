package com.rabbitMQ.ms.infrastructure.messaging.rabbitMQ.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DispachListener {

    static final Logger LOGGER =
            Logger.getLogger(DispachListener.class.getName());

    @RabbitListener(queues = "products.dispatch")
    public void dispatch(Integer order_id) {
        LOGGER.info("Pedido: " + order_id + ": enviado");
    }
}
