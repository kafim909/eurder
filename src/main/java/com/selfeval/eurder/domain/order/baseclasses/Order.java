package com.selfeval.eurder.domain.order.baseclasses;

import com.selfeval.eurder.domain.item.Item;
import com.selfeval.eurder.domain.shared.valueclasses.Price;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class Order {
    private int userId;
    private int id;
    private static int counter;
    private Price totalOrderPrice;
    private final List<ItemGroup> orderedItems = new ArrayList<>();

    public Order (){}

    public Order(int userId) {
        this.userId = userId;
        this.id = ++counter;
        totalOrderPrice = new Price(0.0, "Eur");
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public List<ItemGroup> getOrderedItems() {
        return orderedItems;
    }

    private boolean isItemInStock(Item item, int amount) {
        return item.getStockAmount() > amount;
    }

    private ItemGroup makeNewOrderedItemFromStock(Item item, int amount) {
        ItemGroup orderedItem = new ItemGroup(item.getId(), amount, LocalDate.now().plusDays(1), new Price(item.getPrice()));
        item.orderedItem_updateStockAmount(amount);
        return orderedItem;
    }

    /*----- question for Business Owner here -----*/
    private ItemGroup makeNewForLaterShipping(Item item, int amount) {
        return new ItemGroup(item.getId(), amount, LocalDate.now().plusDays(7), new Price(item.getPrice()));
    }

    private ItemGroup orderedItemWrapper(Item item, int amount) {
        if (isItemInStock(item, amount)) {
            return makeNewOrderedItemFromStock(item, amount);
        }
        return makeNewForLaterShipping(item, amount);
    }

    public Price getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public ItemGroup addItemToOrder(Item item, int amount) {
        orderedItems.add(orderedItemWrapper(item, amount));

        totalOrderPrice = new Price(totalOrderPrice.getAmount() +
                (item.getPrice().getAmount() * amount), totalOrderPrice.getCurrency());

        return orderedItems
                .stream()
                .filter(orderedItem -> orderedItem.getId() == item.getId())
                .findFirst()
                .orElseThrow();
    }
}
