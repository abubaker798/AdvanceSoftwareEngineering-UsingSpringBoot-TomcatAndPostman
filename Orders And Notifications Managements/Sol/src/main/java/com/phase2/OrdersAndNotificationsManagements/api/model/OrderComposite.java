package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrderComposite extends OrderComponent{

    private List<OrderComponent> orders = new ArrayList<>();

    public void addOrderComponent(OrderComponent orderComponent){
        orders.add(orderComponent);
    }
    @Override
    public double calculateTotalPrice() {
        for (OrderComponent order : orders){
          price += order.calculateTotalPrice();
        }
        return price;
    }
}
