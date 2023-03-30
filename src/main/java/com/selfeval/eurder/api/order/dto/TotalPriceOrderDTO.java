package com.selfeval.eurder.api.order.dto;

import com.selfeval.eurder.domain.order.baseclasses.Order;
import com.selfeval.eurder.domain.shared.valueclasses.Price;

public class TotalPriceOrderDTO {
    private Price price;

    public TotalPriceOrderDTO() {}

    public TotalPriceOrderDTO(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }
}
