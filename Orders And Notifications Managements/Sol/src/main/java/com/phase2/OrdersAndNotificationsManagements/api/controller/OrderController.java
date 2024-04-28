package com.phase2.OrdersAndNotificationsManagements.api.controller;
import com.phase2.OrdersAndNotificationsManagements.api.model.*;
import com.phase2.OrdersAndNotificationsManagements.server.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    Response response = new Response();
    @PostMapping("/placeSimpleOrder")
    public Response placeOrder(@RequestBody SimpleOrder order) {
        if (orderService.isEnoughBalance_SimpleOrder(order)) {
            orderService.placeSimpleOrder(order);
            response.setStatus(true);
            response.setMessage("The Simple Order was Placed successfully..........!");
            return response;
        }

        response.setStatus(true);
        response.setMessage("Sorry Your balance is not enough..........!");
        return response;
    }
    @PostMapping("/cancelSimpleOrder")
    Response cancelSimpleOrder(SimpleOrder order){
        if(!orderService.isSimpleOrderFound(order.getOrderId())){
            response.setMessage("Order not found...........!");
            response.setStatus(false);
            return response;
        }
        orderService.cancelSimpleOrder(order.getOrderId());
        response.setStatus(true);
        response.setMessage("The Simple Order was Placed successfully..............!");
        return response;
    }

    @PostMapping("/cancelCompoundOrder")
    Response cancelCompoundOrder(CompoundOrder order){
        if(!orderService.isCompoundOrderFound(order.getOrderId())){
            response.setMessage("Order not found...........!");
            response.setStatus(false);
            return response;
        }
        orderService.cancelCompoundOrder(order.getOrderId());
        response.setStatus(true);
        response.setMessage("The Compound Order was Placed successfully..............!");
        return response;
    }
}