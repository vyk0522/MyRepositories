package com.onejava;

public class LombokApp {
    public static void main(String[] args) {
        ApiClientConfiguration configuration1 = new ApiClientConfiguration("aa", "bb",
                "uu", 8081, false, 88, 99);
        System.out.println(configuration1);

        // We can avoid instantiating using lengthy constructor using builder pattern as shown below

        ApiClientConfiguration configuration = ApiClientConfiguration.builder()
                .host("localhost")
                .port(8080)
                .useHttps(false)
                .connectTimeout(15_000L)
                .readTimeout(5_000L)
                .username("user")
                .password("secret")
                //.port(8081)   // we can call again.
                .build();
        System.out.println(configuration);

        ProductDetail productDetail1 = new ProductDetail();
        ProductDetail productDetail2 = new ProductDetail("1", "iPhone", 22.0);
        productDetail1.setProductName("Nexus");
        System.out.println(productDetail1.getProductName());
        System.out.println(productDetail2);
    }
}
