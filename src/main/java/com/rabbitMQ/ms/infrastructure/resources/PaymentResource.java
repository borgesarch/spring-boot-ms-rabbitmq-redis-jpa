package com.rabbitMQ.ms.infrastructure.resources;

import com.rabbitMQ.ms.domain.aggregates.Payment;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel="payments", path="payments")
public interface PaymentResource extends JpaRepository<Payment, String> {

    @Query(name = "product.queries.find_by_id", nativeQuery = true)
    @Cacheable(value = "payments", key="#id", condition="#id != null")
    Optional<Payment> findById(@PathVariable String id);

    @Cacheable(cacheNames="payments", key="#root.method.name")
    List<Payment> findAll();

    @Query(name = "product.queries.find_by_status", nativeQuery = true)
    List<Payment> findAllByStatus(@PathVariable String status);

    @PostMapping
    @CacheEvict(cacheNames = "payments", allEntries = true)
    Payment save(@RequestBody @Valid Payment payment);

}
