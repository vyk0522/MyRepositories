package com.onejava.ecommerce.jpa.repository;

import com.onejava.ecommerce.jpa.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
