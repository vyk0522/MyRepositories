package com.onejava.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsageCostDetail {
    @Id
    private int id;
    private String type;
    private String offer;
    private BigDecimal conversionMultiple;
}
