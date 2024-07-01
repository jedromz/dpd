package com.dpdgroup.mailingservice;

import com.dpdgroup.api.model.Order;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
@RequiredArgsConstructor
public class OrdersKafkaListener {

    @KafkaListener(topics = "${kafka.topic}")
    public void listener(ConsumerRecord<String, Order> cr) {
        Order order = cr.value();
        System.out.println("Order received: " + order);
    }
}
