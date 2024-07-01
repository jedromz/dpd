package com.dpdgroup.api.api;

import com.dpdgroup.api.kafka.KafkaProperties;
import com.dpdgroup.api.model.Order;
import com.dpdgroup.api.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final OrderService orderService;
    private final KafkaProperties kafkaProperties;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<OrderResponse> sendMessage(@Valid @RequestBody OrderRequest order) {
        Order savedOrder = orderService.processOrder(modelMapper.map(order, Order.class));
        kafkaTemplate.send(kafkaProperties.getTopic(), order);
        return ResponseEntity.ok(modelMapper.map(savedOrder, OrderResponse.class));
    }
}
