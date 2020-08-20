package com.onejava.ecommerce.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sku;
    private String brand;
    private double price;
    private String color;
    private int size;
    @NotNull
    private String name;

    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "product_id", nullable = false))
    @Size(min = 1)
    @NotNull
    private List<String> images;

    @ManyToOne(targetEntity = Seller.class)
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private Seller seller;

    @ManyToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @Size(min = 1)
    @NotNull
    private Set<Category> categories; // when using @ManyToMany annotation, always use Set and avoid List

}
