package com.selfeval.eurder.domain.shared.valueclasses;

public class Price {
    private final double amount;
    private final String currency;

    public Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Price (Price price){
        this.amount = price.getAmount();
        this.currency = price.getCurrency();
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
