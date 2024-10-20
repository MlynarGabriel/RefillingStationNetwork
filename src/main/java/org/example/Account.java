package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Double> topUpHistory;
    private Customer customer;

    public Account() {
        this.balance = 0.0;
        this.topUpHistory = new ArrayList<>();
    }

    public void topUp(double amount) {
        this.balance += amount;
        topUpHistory.add(amount);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTopUpHistory(List<Double> topUpHistory) {
        this.topUpHistory = topUpHistory;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void displayInvoice(){
        //in Bearbeitugn
    }

    public double getBalance() {
        return balance;
    }

    public List<Double> getTopUpHistory() {
        return topUpHistory;
    }
}