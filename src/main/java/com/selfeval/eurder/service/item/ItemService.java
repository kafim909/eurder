package com.selfeval.eurder.service.item;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.item.ItemRepository;
import com.selfeval.eurder.service.item.dto.ItemMinimumDataDTO;
import com.selfeval.eurder.service.item.mappers.ItemOutputMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemOutputMapper outputMapper;

    public ItemService(ItemRepository itemRepository, ItemOutputMapper outputMapper) {
        this.itemRepository = itemRepository;
        this.outputMapper = outputMapper;
    }

    public ItemMinimumDataDTO createItem(Item item){
        return outputMapper.toMinimumDataDto(itemRepository.addItem(item));
    }
}
