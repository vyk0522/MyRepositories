package com.onejava.service.stream;

import com.onejava.service.model.ProductDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class NtvProductProducer {
    private Map<String, String> productMap = new HashMap<>();

     {
        productMap.put("0", "Classic");
        productMap.put("1", "Cinema");
        productMap.put("2", "Sports");
        productMap.put("3", "Kids");
        productMap.put("4", "Entertainment");

    }

    /*
    By default, the supplier will be invoked every second.
    On each invocation, the supplier method sendEvents constructs a ProductDetail object.
     */
    @Bean
    public Supplier<ProductDetail> sendEvents() {
        return () -> getProductDetails();
    }

    private ProductDetail getProductDetails(){
        String productID = Integer.toString(new Random().nextInt(5));
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productID);
        productDetail.setProductName(productMap.get(productID));
        productDetail.setBtPrice(new Random().nextDouble());
        return productDetail;
    }


}
