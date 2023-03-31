package com.selfeval.eurder.api.order.mappers;

import com.selfeval.eurder.api.order.dto.ItemAmountDTO;
import com.selfeval.eurder.api.order.dto.ItemIdDTO;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OrderInputMapper {

    public Map<Integer, Integer> mapToCleanMap(Map<String, String> order) {
        Map<Integer, Integer> cleanedMap = new HashMap<>();
        order.keySet()
                .forEach(key -> cleanedMap.put(Integer.parseInt(key),
                                Integer.parseInt(order.get(key))));
        return cleanedMap;
    }


}
