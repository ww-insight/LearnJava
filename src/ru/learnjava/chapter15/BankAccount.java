package ru.learnjava.chapter15;

/**
 * Created by belyakovvv1 on 14.07.2017.
 */
public class BankAccount {

    private int balance = 100;

    public int getBalance () {
        return balance;
    }

    public int withdraw (int amount) {
        return balance -= amount;
    }
}

