package com.onejava.service.model;

public class NTVProductDetail {
    private String productId;
    private String productName;
    private double btPrice;
    private double ntvPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBtPrice() {
        return btPrice;
    }

    public void setBtPrice(double btPrice) {
        this.btPrice = btPrice;
    }

    public double getNtvPrice() {
        return ntvPrice;
    }

    public void setNtvPrice(double ntvPrice) {
        this.ntvPrice = ntvPrice;
    }
}
