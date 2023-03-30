package com.selfeval.eurder.api.order;

import com.selfeval.eurder.api.order.dto.ItemAmountDTO;
import com.selfeval.eurder.api.order.dto.ItemIdDTO;
import com.selfeval.eurder.api.order.dto.TotalPriceOrderDTO;
import com.selfeval.eurder.api.order.mappers.OrderInputMapper;
import com.selfeval.eurder.api.order.mappers.OrderOutputMapper;
import com.selfeval.eurder.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderInputMapper inputMapper;
    private final OrderOutputMapper outputMapper;
    private final OrderService orderService;

    public OrderController(OrderInputMapper inputMapper, OrderOutputMapper outputMapper, OrderService orderService) {
        this.inputMapper = inputMapper;
        this.outputMapper = outputMapper;
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/{userId}/create", consumes = "application/json", produces = "application/json")
    public TotalPriceOrderDTO createOrder(@PathVariable int userId, @RequestBody Map<String, String> order) {
        return outputMapper.toTotalPriceOrderDTO(
                orderService.createNewOrder(inputMapper.mapToCleanMap(order), userId));
    }

}
