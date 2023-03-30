package com.selfeval.eurder.service.item;

import com.selfeval.eurder.domain.ValidationTools;
import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.api.item.dto.ItemMinimumDataDTO;
import com.selfeval.eurder.api.item.mappers.ItemOutputMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item, int userId){
        ValidationTools.UserAnAdminOrElseThrowException(userId);
        return itemRepository.addItem(item);
    }
}
