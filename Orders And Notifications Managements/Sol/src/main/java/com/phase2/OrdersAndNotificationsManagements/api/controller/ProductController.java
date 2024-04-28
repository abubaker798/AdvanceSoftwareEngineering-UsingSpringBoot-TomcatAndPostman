package com.phase2.OrdersAndNotificationsManagements.api.controller;

import com.phase2.OrdersAndNotificationsManagements.api.model.Product;
import com.phase2.OrdersAndNotificationsManagements.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(value = "/display")
    public Map<String, Product> displayAllProducts() {
        return productService.getAllProducts();
    }


}


