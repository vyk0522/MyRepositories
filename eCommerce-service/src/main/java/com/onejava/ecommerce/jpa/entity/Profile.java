package com.onejava.ecommerce.jpa.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "profiles")
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    private String title;
    private String company;
    @NotNull
    private String email;
    @NotNull
    private String address;
    private String phone_number;
}
