package com.selfeval.eurder.domain.order;

import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.domain.order.baseclasses.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {
    private final ItemRepository itemRepository;
    private final List<Order> orderList = new ArrayList<>();

    public OrderRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Order createOrder(Map<Integer, Integer> order, int userId){
        Order newOrder = new Order(userId);
        order.keySet()
                .forEach(key -> newOrder.addItemToOrder(
                        itemRepository.getItemById(
                                key.intValue()), order.get(key)));
        return newOrder;
    }
}
