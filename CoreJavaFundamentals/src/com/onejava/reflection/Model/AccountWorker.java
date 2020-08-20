package com.onejava.reflection.Model;

public class AccountWorker implements TaskWorker<BankAccount> {
    BankAccount account;
    Runnable task = () -> System.out.println(account.getId());

    @Override
    public void setTarget(BankAccount target) {
        if (BankAccount.class.isInstance(target)){
            account = target;
        }
        else{
            throw new IllegalArgumentException("Invalid");
        }
    }

    @Override
    public void doTask() {
        Thread t = new Thread(task);
        t.start();
    }
}
