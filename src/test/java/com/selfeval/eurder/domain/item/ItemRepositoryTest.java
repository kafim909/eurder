package com.selfeval.eurder.domain.item;

import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    private ItemRepository itemRepository;
    private Item item;
    @BeforeEach
    void setUp() {
        itemRepository = new ItemRepository();
        item = new Item(
                "Cola",
                "Boisson",
                new Price(1.0, "Eur"),
                10);
    }

    @Test
    void getItemById_whenItemAdded_ItemShouldBeInTheRepository() {
        itemRepository.addItem(item);
        assertEquals(item, itemRepository.getItemById(item.getId()));
    }
}