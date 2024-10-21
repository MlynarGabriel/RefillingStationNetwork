package org.example;

import java.util.Date;

public class TopUp {
    private Date date = new Date();
    private double amount;

    public TopUp(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }
}
