package com.selfeval.eurder.service.item.dto;

public class ItemMinimumDataDTO {
    private final String name;
    private final int stockAmount;

    public ItemMinimumDataDTO(String name, int stockAmount) {
        this.name = name;
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public int getStockAmount() {
        return stockAmount;
    }
}
