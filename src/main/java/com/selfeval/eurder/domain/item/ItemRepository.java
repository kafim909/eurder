package com.selfeval.eurder.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {
    private final List<Item> itemList = new ArrayList<>();

    public List<Item> getItemList() {
        return itemList;
    }

    public Item addItem(Item item){
        itemList.add(item);
        return item;
    }

    public Item getItemById(int id){
        return itemList
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();
    }
}
