package com.phase2.OrdersAndNotificationsManagements.server;

import com.phase2.OrdersAndNotificationsManagements.Common;
import com.phase2.OrdersAndNotificationsManagements.api.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public  class ProductService {
    private List<Product> products = Arrays.asList(
            new Product("101", "name1", "vendor1", "category1", 200, 10),
            new Product("102", "name2", "vendor2", "category2", 202, 20),
            new Product("103", "name3", "vendor3", "category3", 203, 15),
            new Product("104", "name4", "vendor4", "category4", 204, 30),
            new Product("105", "name5", "vendor5", "category5", 205, 45)
    );

    ProductService(){
        for (Product product: products){
            if(product.getRemainingParts() > 0)
                Common.Products.put(product.getSerialNumber(), product);
        }
    }


    public Map<String, Product> getAllProducts() {
        return Common.Products;
    }

    public Product getProductBySerialNumber(String serialNumber){
        return Common.Products.get(serialNumber);
    }

    public void updateProducts(Product product){
        Common.Products.replace(product.getProductName(), product);
    }
}