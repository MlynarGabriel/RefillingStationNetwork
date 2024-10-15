package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Double> topUpHistory;

    public Account() {
        this.balance = 0.0;
        this.topUpHistory = new ArrayList<>();
    }

    public void topUp(double amount) {
        this.balance += amount;
        topUpHistory.add(amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<Double> getTopUpHistory() {
        return topUpHistory;
    }
}