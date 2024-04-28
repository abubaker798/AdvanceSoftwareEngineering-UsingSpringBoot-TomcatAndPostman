package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class OrderComponent {
    private Integer orderId;
    private Customer customer;
    double price = 0;
    double calculateTotalPrice(){return price;}
}
