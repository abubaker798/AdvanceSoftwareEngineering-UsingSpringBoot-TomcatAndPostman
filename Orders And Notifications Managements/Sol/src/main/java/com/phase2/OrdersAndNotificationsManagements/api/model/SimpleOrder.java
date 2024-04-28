package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SimpleOrder extends OrderComponent {
    private List<Product> products;
    @Override
    public double calculateTotalPrice() {
        double price = 0;
        for (Product product: this.products){
            price+=product.getPrice();
        }
        return price;
    }
}
