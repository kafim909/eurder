package com.selfeval.eurder.domain.order.baseclasses;

import com.selfeval.eurder.domain.shared.valueclasses.Price;

import java.time.LocalDate;

public class ItemGroup {
    private final int id;
    private final int amount;
    private final LocalDate shippingDate;
    private final Price price;

    public ItemGroup(int id, int amount, LocalDate shippingDate, Price price) {
        this.id = id;
        this.amount = amount;
        this.shippingDate = shippingDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public Price getPrice() {
        return price;
    }
}
