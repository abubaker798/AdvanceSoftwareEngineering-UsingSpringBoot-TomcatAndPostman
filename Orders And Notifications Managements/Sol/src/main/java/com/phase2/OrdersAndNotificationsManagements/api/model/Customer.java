package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Customer {
    private Account account;
    private String CustomerName;
    private String address;
    private String phoneNumber;
    public Customer(){}
}