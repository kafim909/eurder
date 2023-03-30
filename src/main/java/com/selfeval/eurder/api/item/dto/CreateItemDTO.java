package com.selfeval.eurder.api.item.dto;

import com.selfeval.eurder.domain.shared.valueclasses.Price;

public class CreateItemDTO {
    private final String name;
    private final String description;
    private final Price price;
    private final int stockAmount;

    public CreateItemDTO(String name, String description, Price price, int stockAmount) {
        this.name = name;
        this.description = description;
        this.price = new Price(price);
        this.stockAmount = stockAmount;
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
