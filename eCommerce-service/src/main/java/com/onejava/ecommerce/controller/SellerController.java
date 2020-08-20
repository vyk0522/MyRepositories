package com.onejava.ecommerce.controller;

import com.onejava.ecommerce.jpa.entity.Seller;
import com.onejava.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getSellers() {
        return sellerService.getSellers();
    }

    /*
    It adds new seller.
    Seller should contain all the mandatory fields. Else exception
     */
    @PostMapping
    public ResponseEntity<Seller> addNewSeller(@RequestBody Seller seller){
        return sellerService.addNewSeller(seller);
    }

    /*
    It deletes all sellers and their profiles too
     */
    @DeleteMapping
    public void deleteAllSellers(){
        sellerService.deleteAllSellers();
    }
}
