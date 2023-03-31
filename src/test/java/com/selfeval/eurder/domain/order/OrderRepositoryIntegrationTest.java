package com.selfeval.eurder.domain.order;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.domain.order.baseclasses.Order;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Component
class OrderRepositoryIntegrationTest {

    private OrderRepository orderRepository;
    private ItemRepository itemRepositoryMock;
    private Map<Integer, Integer> order = new HashMap<>();
    private Order newOrder;

    @BeforeEach
    void setUp() {
        itemRepositoryMock = Mockito.mock(ItemRepository.class);
        orderRepository = new OrderRepository(itemRepositoryMock);
        order.put(1, 1);
        order.put(2, 1);
        Mockito.when(itemRepositoryMock.getItemById(1))
                .thenReturn(new Item("Cola", "Boisson", new Price(1.0, "Eur"), 10));
        Mockito.when(itemRepositoryMock.getItemById(2))
                .thenReturn(new Item("Iced Tea", "Boisson", new Price(5.0, "Eur"), 10));
        newOrder = orderRepository.createOrder(order, 1);
    }

    @Test
    void createOrder_whenPassingGivingAMapWithItemIdAndAmount_ThenCreateAndReturnOrder() {
        assertNotNull(newOrder);
    }

    @Test
    void createOrder_whenOrderCreated_thenAssertTotalPriceIsRight() {
        assertEquals(6.0, newOrder.getTotalOrderPrice().getAmount());
    }
}