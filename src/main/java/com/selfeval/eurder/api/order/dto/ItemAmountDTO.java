package com.selfeval.eurder.api.order.dto;

public class ItemAmountDTO {
    private final int amount;

    public ItemAmountDTO(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
