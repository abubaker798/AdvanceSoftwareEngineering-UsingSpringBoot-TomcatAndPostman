package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.annotation.Order;

import java.util.List;

@Setter
@Getter
public class CompoundOrder extends OrderComponent {
    private OrderComposite orders;

    public CompoundOrder(){}
    public CompoundOrder(OrderComposite orders){
        this.orders = orders;
    }
    @Override
    public double calculateTotalPrice() {
        return orders.calculateTotalPrice();
    }
}
