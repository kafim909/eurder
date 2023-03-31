package com.selfeval.eurder.api.order.mappers;

import com.selfeval.eurder.api.order.dto.TotalPriceOrderDTO;
import com.selfeval.eurder.domain.order.baseclasses.Order;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.springframework.stereotype.Component;

@Component
public class OrderOutputMapper {
    public TotalPriceOrderDTO toTotalPriceOrderDTO(Order order) {
        return new TotalPriceOrderDTO(new Price(order.getTotalOrderPrice()));
    }


}
