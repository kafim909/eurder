package com.selfeval.eurder.domain.item;

import com.selfeval.eurder.domain.shared.valueclasses.Price;

public class Item {

    private final int id;
    private static int counter;
    private final String name;
    private final String description;
    private final Price price;
    private final int stockAmount;

    public Item(String name, String description, Price price, int stockAmount) {
        id = ++counter;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Price getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }
}
