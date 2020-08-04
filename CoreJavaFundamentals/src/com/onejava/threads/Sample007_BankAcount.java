package com.onejava.threads;

import com.onejava.threads.helper.BankAccount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample007_BankAcount {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5); // 2 treads are used out of 5
        BankAccount account = new BankAccount(500);
        Runnable task1 = () -> doTransaction(account, 'D', 300);
        Runnable task2 = () -> doTransaction(account, 'W', 200);

        service.submit(task1);
        service.submit(task2);

        Thread.sleep(200);
        System.out.println(account.getBalance());

        service.shutdown();
    }

    /*
        If transactionType is withdraw, just withdraw the amount.
        If transactionType is deposit, deposit the amount and if new balance is > 500, deposit bonus as well
         */
    private static void doTransaction(BankAccount account, char transactionType, int amount) {
        if(transactionType == 'W'){
            account.withdraw(amount);
        }
        else if(transactionType == 'D') {
            synchronized (account) {
                account.deposit(amount);
                if (account.getBalance() > 500){
                    int bonus = (int)((account.getBalance() - 500) * 0.1);
                    account.deposit(bonus);
                }
            }
        }
        System.out.println(account.getBalance());
    }

}
