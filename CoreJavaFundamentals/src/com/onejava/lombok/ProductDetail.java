package com.onejava.lombok;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductDetail {
    private String productId;
    private String productName;
    private Double price;
}
