package com.selfeval.eurder.api.item;

import com.selfeval.eurder.api.item.mappers.ItemOutputMapper;
import com.selfeval.eurder.service.item.ItemService;
import com.selfeval.eurder.api.item.dto.CreateItemDTO;
import com.selfeval.eurder.api.item.dto.ItemMinimumDataDTO;
import com.selfeval.eurder.api.item.mappers.ItemInputMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items")
public class ItemController {

    private final ItemService itemService;
    private final ItemInputMapper inputMapper;
    private final ItemOutputMapper outputMapper;

    public ItemController(ItemService itemService, ItemInputMapper inputMapper, ItemOutputMapper outputMapper) {
        this.itemService = itemService;
        this.inputMapper = inputMapper;
        this.outputMapper = outputMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/{userId}/createitem", consumes = "application/json", produces = "application/json")
    public ItemMinimumDataDTO createItem(@PathVariable int userId, @RequestBody CreateItemDTO createItemDto){
        return outputMapper.toMinimumDataDto(
                itemService.createItem(
                        inputMapper.mapToItem(createItemDto), userId));
    }
}
