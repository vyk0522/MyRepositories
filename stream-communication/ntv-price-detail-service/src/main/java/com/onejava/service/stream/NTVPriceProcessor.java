package com.onejava.service.stream;

import com.onejava.service.model.NTVProductDetail;
import com.onejava.service.model.ProductDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Function;

@Configuration
public class NTVPriceProcessor {

    @Bean
    public Function<ProductDetail, NTVProductDetail> processNTVPrice(){
        return productDetail -> getNTVProductDetails(productDetail);
    }

    private NTVProductDetail getNTVProductDetails(ProductDetail productDetail){
        NTVProductDetail ntvProductDetail = new NTVProductDetail();
        ntvProductDetail.setProductId(productDetail.getProductId());
        ntvProductDetail.setProductName(productDetail.getProductName());
        ntvProductDetail.setBtPrice(productDetail.getBtPrice());
        ntvProductDetail.setNtvPrice(new Random().nextDouble());
        return ntvProductDetail;
    }


}
