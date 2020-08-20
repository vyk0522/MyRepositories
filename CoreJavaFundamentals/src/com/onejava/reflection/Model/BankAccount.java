package com.onejava.reflection.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
    private String id;
    private int balance;

    public int deposit(String id, int amount){
        this.id = id;
        balance = balance + amount;
        return balance;
    }
}
