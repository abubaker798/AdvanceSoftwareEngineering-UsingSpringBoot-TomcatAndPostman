package com.phase2.OrdersAndNotificationsManagements;

import com.phase2.OrdersAndNotificationsManagements.api.model.*;

import java.util.HashMap;
import java.util.Map;

public class Common {
    public static Map<String, Customer> customers = new HashMap<>();
    public static Map<String, Product> Products = new HashMap<>();
    public static Map<Integer, SimpleOrder> SimpleOrders = new HashMap<>();
    public static Map<Integer, CompoundOrder> CompoundOrder = new HashMap<>();

}