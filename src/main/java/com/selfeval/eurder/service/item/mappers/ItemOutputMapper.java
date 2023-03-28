package com.selfeval.eurder.service.item.mappers;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.service.item.dto.ItemMinimumDataDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemOutputMapper {
    public ItemMinimumDataDTO toMinimumDataDto(Item item) {
        return new ItemMinimumDataDTO(item.getName(), item.getStockAmount());
    }

}
