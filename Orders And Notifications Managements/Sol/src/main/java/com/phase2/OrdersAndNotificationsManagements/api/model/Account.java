package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account {
    private String userName;
    private String password;

    private double balance;

    private boolean login = false;
}
