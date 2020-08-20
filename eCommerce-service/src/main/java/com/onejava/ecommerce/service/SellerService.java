package com.onejava.ecommerce.service;

import com.onejava.ecommerce.jpa.entity.Seller;
import com.onejava.ecommerce.jpa.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getSellers() {
        return sellerRepository.findAll();
    }

    public ResponseEntity<Seller> addNewSeller(Seller seller){
        sellerRepository.save(seller);
        return new ResponseEntity<>(seller, HttpStatus.CREATED);
    }

    public void deleteAllSellers(){
        sellerRepository.deleteAll();
    }
}
