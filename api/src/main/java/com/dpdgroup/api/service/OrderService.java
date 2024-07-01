package com.dpdgroup.api.service;

import com.dpdgroup.api.model.Order;
import com.dpdgroup.api.model.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order processOrder(Order order) {
        return orderRepository.findByShipmentNumber(order.getShipmentNumber())
                .map(existingOrder -> {
                    existingOrder.setStatusCode(order.getStatusCode());
                    return orderRepository.save(existingOrder);
                })
                .orElseGet(() -> orderRepository.save(order));
    }
}
