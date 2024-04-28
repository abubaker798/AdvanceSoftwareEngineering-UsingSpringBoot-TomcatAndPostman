package com.phase2.OrdersAndNotificationsManagements.server;

import com.phase2.OrdersAndNotificationsManagements.Common;
import com.phase2.OrdersAndNotificationsManagements.api.model.CompoundOrder;
import com.phase2.OrdersAndNotificationsManagements.api.model.OrderComponent;
import com.phase2.OrdersAndNotificationsManagements.api.model.SimpleOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void placeSimpleOrder(SimpleOrder order) {
        Common.SimpleOrders.put(Common.SimpleOrders.size(), order);
    }
    public void placeCompoundOrder(CompoundOrder order) {
        Common.CompoundOrder.put(Common.CompoundOrder.size(), order);
    }
    public boolean isEnoughBalance_SimpleOrder(SimpleOrder order) {
        double customerBalance = order.getCustomer().getAccount().getBalance();
        double ordersPrice = order.calculateTotalPrice();
        return customerBalance >= ordersPrice;
    }
    public boolean isEnoughBalance_CompoundOrder(CompoundOrder order) {
        double customerBalance = order.getCustomer().getAccount().getBalance();
        double ordersPrice = order.calculateTotalPrice();
        return customerBalance >= ordersPrice;
    }

    public void cancelSimpleOrder(Integer orderId) {
        Common.CompoundOrder.remove(orderId);
    }

    public void cancelCompoundOrder(Integer orderId) {
       Common.CompoundOrder.remove(orderId);
    }


   public boolean isCompoundOrderFound(Integer orderId){
        OrderComponent order = new CompoundOrder();
        order = Common.CompoundOrder.get(orderId);
        return order != null;
    }

  public   boolean isSimpleOrderFound(Integer orderId){
        OrderComponent order = new SimpleOrder();
        order = Common.SimpleOrders.get(orderId);
        return order != null;
    }


}

