package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Account {
    private double balance;
    private List<TopUp> topUpHistory;
    private Customer customer;




    public Account() {
        this.balance = 0.0;
        this.topUpHistory = new ArrayList<>();
    }

    public List<TopUp> getTopUpHistory() {
        return topUpHistory;
    }

    public void setTopUpHistory(List<TopUp> topUpHistory) {
        this.topUpHistory = topUpHistory;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    //------------------

    public void topUp(double amount) {
        this.balance += amount;
        this.topUpHistory.add(new TopUp(new Date(), amount)); //Add top-up to history with current date
    }

    public boolean verifyBalance(double expectedBalance) {
        return Math.abs(expectedBalance - getBalance()) <= 0.01;
    }





}