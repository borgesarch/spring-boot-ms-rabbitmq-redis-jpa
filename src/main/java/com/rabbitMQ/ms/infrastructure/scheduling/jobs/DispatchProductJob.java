package com.rabbitMQ.ms.infrastructure.scheduling.jobs;


import com.rabbitMQ.ms.TestApplication;
import com.rabbitMQ.ms.domain.aggregates.Payment;
import com.rabbitMQ.ms.infrastructure.resources.PaymentResource;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@EnableScheduling
@Component
public class DispatchProductJob {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PaymentResource paymentResource;

    @Scheduled(fixedDelay = 15000)
    @Transactional
    public void pushMessage() {

        List<Payment> paymentsApproved = paymentResource.findAllByStatus("approved");

        paymentsApproved.forEach(payment ->{

            payment.setStatus("dispatched");

            rabbitTemplate.convertAndSend(
                    "products.dispatch",
                    payment.getOrder_id()
            );
            paymentResource.save(payment);
        });
    }
}
