package com.onejava.serialization;

import com.onejava.serialization.model.BankAccount;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Sample001 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234", 500);
        account.deposit(200);
        serializeAccount(account, "account2.dat");
        account.deposit(100);
        BankAccount account1 = deSerializeAccount("account2.dat");
        System.out.println(account1);
    }

    private static void serializeAccount(BankAccount account, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            outputStream.writeObject(account);
        }
        catch (IOException ex){

        }
    }

    private static BankAccount deSerializeAccount(String fileName) {
        BankAccount account = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            account = (BankAccount) inputStream.readObject();
        }
        catch (IOException ex){

        } catch (ClassNotFoundException e) {
        }
        return account;
    }
}
