package com.selfeval.eurder.api.item.mappers;

import com.selfeval.eurder.api.item.dto.CreateItemDTO;
import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.springframework.stereotype.Component;

@Component
public class ItemInputMapper {
    public Item mapToItem(CreateItemDTO createItemDto) {
        return new Item(createItemDto.getName(),
                createItemDto.getDescription(),
                new Price(createItemDto.getPrice()),
                createItemDto.getStockAmount());
    }
}
