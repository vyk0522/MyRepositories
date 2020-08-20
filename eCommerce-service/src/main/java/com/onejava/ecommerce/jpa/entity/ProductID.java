package com.onejava.ecommerce.jpa.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProductID implements Serializable {
    private static final long serialVersionUID = -6686929097316849097L;
    private String sku;
    private Seller seller;
}
