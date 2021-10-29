package com.rabbitMQ.ms.domain.aggregates;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();

    @NotBlank(message = "Campo status é requerido!")
    @Column(name = "status")
    private String status;

    @NotNull()
    @Min(value = 1, message = "O campo order_id é requerido!")
    @Column(name = "order_id")
    private Integer order_id;

    @NotNull()
    @Min(value = 1, message = "O campo produto é requerido!")
    @Column(name = "product_id")
    private Integer product_id;

    @NotNull()
    @Min(value = 1, message = "O campo user_id é requerido!")
    @Column(name = "user_id")
    private Integer user_id;

    @NotNull()
    @Min(value = 1, message = "O campo card_number é requerido!")
    @Column(name = "card_number")
    private String card_number;

    @Column(name = "due_date")
    private Date due_date = new Date();

}
