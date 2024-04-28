package com.phase2.OrdersAndNotificationsManagements.api.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Product {
    private String serialNumber;
    private String productName;
    private String vendor;
    private String category;
    private double price;
    private int remainingParts;

    public Product(String serialNumber, String productName, String vendor, String category, int price, int remainingParts) {
        this.serialNumber = serialNumber;
        this.productName = productName;
        this.vendor = vendor;
        this.category = category;
        this.price = price;
        this.remainingParts = remainingParts;
    }
}