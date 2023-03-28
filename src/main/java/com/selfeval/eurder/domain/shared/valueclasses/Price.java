package com.selfeval.eurder.domain.shared.valueclasses;

public class Price {
    private final double price;
    private final String currency;

    public Price(double price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
