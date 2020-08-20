package com.onejava.serialization.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
1. first version of BankAccount we serialized has only two fields -- id, balance
2. Second version of BankAccount has two additional field -- lastTxType and lastTxAmount
 */
@ToString
@AllArgsConstructor
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 8880914627010800545L;
    private String id;
    @Getter private int balance;
    private char lastTxType;
    private int lastTxAmount;

    public BankAccount(String id, int balance) {
        this.id =id;
        this.balance = balance;
    }

    public void deposit(int amount){
        balance = balance + amount;
        lastTxType = 'D';
        lastTxAmount = amount;
    }

    public void withdraw(int amount){
        balance = balance - amount;
        lastTxType = 'W';
        lastTxAmount = amount;
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
    }

    /*
    If we don't override and make lastTxType to unknown and lastTxAmount to -1
    We can not differentiate between last version and current version deserialization as
     old version gives default value when that field is not there.
     */
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = inputStream.readFields();
        id = (String) fields.get("id", null);
        balance = fields.get("balance", 0);
        lastTxType = fields.get("lastTxType", 'u');
        lastTxAmount = fields.get("lastTxAmount", -1);
    }
}
