package com.selfeval.eurder.service.item.mappers;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.service.item.dto.CreateItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemInputMapper {
    public Item fromCreateItemDtoToItem(CreateItemDTO createItemDto) {
        return new Item(createItemDto.getName(),
                createItemDto.getDescription(),
                createItemDto.getPrice(),
                createItemDto.getStockAmount());
    }
}
