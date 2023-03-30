package com.selfeval.eurder.service.item;

import com.selfeval.eurder.domain.ValidationTools;
import com.selfeval.eurder.domain.exceptions.UnauthorizedException;
import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import com.selfeval.eurder.domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
class ItemServiceTest {

    private ItemRepository itemRepositoryMock;
    private ItemService itemService;
    private Item item;

    @BeforeEach
    void setUp() {
        itemRepositoryMock = Mockito.mock(ItemRepository.class);
        itemService = new ItemService(itemRepositoryMock);
        item = new Item("Cola", "Boisson", new Price(1.5, "Eur"), 10);
    }

}