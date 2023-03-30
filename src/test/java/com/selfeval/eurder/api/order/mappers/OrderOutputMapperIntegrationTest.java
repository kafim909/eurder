package com.selfeval.eurder.api.order.mappers;

import com.selfeval.eurder.api.order.dto.TotalPriceOrderDTO;
import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.domain.order.OrderRepository;
import com.selfeval.eurder.domain.order.baseclasses.Order;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderOutputMapperIntegrationTest {
    private OrderOutputMapper outputMapper;
    private Order order;

    @BeforeEach
    void setUp() {
        outputMapper = new OrderOutputMapper();
        order = new Order(1);
        order.addItemToOrder(new Item(
                "Cola",
                "Boisson",
                new Price(1.0, "Eur"),
                10), 10);
    }

    @Test
    void toTotalOrderPriceDTO_whenGivingAnOrderAsArgument_ShouldContainTotalPrice() {
        TotalPriceOrderDTO priceOrderDTO = outputMapper.toTotalPriceOrderDTO(order);
        assertEquals(10.0, priceOrderDTO.getPrice().getAmount());
    }
}