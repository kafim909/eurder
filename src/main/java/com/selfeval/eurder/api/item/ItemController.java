package com.selfeval.eurder.api.item;

import com.selfeval.eurder.service.item.ItemService;
import com.selfeval.eurder.service.item.dto.CreateItemDTO;
import com.selfeval.eurder.service.item.dto.ItemMinimumDataDTO;
import com.selfeval.eurder.service.item.mappers.ItemInputMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items")
public class ItemController {

    private final ItemService itemService;
    private final ItemInputMapper inputMapper;

    public ItemController(ItemService itemService, ItemInputMapper inputMapper) {
        this.itemService = itemService;
        this.inputMapper = inputMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/admin/createitem", consumes = "application/json", produces = "application/json")
    public ItemMinimumDataDTO createItem(@RequestBody CreateItemDTO createItemDto){
        return itemService.createItem(inputMapper.fromCreateItemDtoToItem(createItemDto));
    }
}
