package com.selfeval.eurder.service.order;

import com.selfeval.eurder.domain.ValidationTools;
import com.selfeval.eurder.domain.order.OrderRepository;
import com.selfeval.eurder.domain.order.baseclasses.Order;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createNewOrder(Map<Integer, Integer> order, int userId){
//        ValidationTools.UserACustomerOrElseThrowException(userId);
        return orderRepository.createOrder(order, userId);
    }
}
