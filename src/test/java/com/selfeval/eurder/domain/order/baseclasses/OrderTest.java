package com.selfeval.eurder.domain.order.baseclasses;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Component
class OrderTest {

    private Order order;
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Cola", "Boisson", new Price(1.2, "Eur"), 10);
    }

    @Test
    void addItemToOrder_whenStockAmountLessThanOrderAmount_thenShippingDateIsNowPlus7Days() {
        assertEquals(LocalDate.now()
                        .plusDays(7),
                order.addItemToOrder(item, 15)
                        .getShippingDate());
    }

    @Test
    void addItemToOrder_whenStockAmountMoreThanOrderAmount_thenShippingDateIsNowPlusOneDay() {
        assertEquals(LocalDate.now()
                        .plusDays(1),
                order.addItemToOrder(item, 5)
                        .getShippingDate());
    }
}