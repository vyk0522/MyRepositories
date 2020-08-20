package com.onejava.reflection;

import com.onejava.reflection.Model.BankAccount;
import com.onejava.reflection.Model.TaskWorker;

public class Sample003_Worker {
    public static void main(String[] args) throws Exception {
        BankAccount account = new BankAccount("123", 500);
        startWork("com.onejava.reflection.Model.AccountWorker", account);
    }

    /*
    To create TaskWorker object using Reflection
     */
    static void startWork(String workerTypeName, Object workerTarget) throws Exception {
        Class<?> c = Class.forName(workerTypeName);
        TaskWorker worker = (TaskWorker) c.newInstance();
        worker.setTarget(workerTarget);
        worker.doTask();
    }

}
