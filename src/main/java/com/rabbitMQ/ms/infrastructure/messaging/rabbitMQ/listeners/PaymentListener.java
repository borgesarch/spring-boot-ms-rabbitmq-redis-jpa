package com.rabbitMQ.ms.infrastructure.messaging.rabbitMQ.listeners;

import com.rabbitMQ.ms.domain.aggregates.Payment;
import com.rabbitMQ.ms.infrastructure.resources.PaymentResource;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PaymentListener {

    static final Logger LOGGER =
            Logger.getLogger(PaymentListener.class.getName());

    @Autowired
    private PaymentResource paymentResource;

    @RabbitListener(queues = "products")
    public void listener(Payment message) {
        LOGGER.info(message.getId());
        LOGGER.info(message.getStatus());
        LOGGER.info(message.getProduct_id().toString());
        paymentResource.save(message);
    }
}
