package org.example;

import java.time.Duration;
import java.util.Date;

public class ChargeSession {

    private long duration;  // in minutes
    private double energyCharged;
    private double totalPrice;
    private Account account;
    private ChargingPoint chargingPoint;

    public ChargeSession() {
        this.duration = 0;  // Example duration
        this.energyCharged = 0.0;
        this.totalPrice = 0.0;
        this.account = new Account();
        this.chargingPoint = new ChargingPoint();
    }


    public void setEnergyCharged(double energyCharged) {
        this.energyCharged = energyCharged;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ChargingPoint getChargingPoint() {
        return chargingPoint;
    }

    public void setChargingPoint(ChargingPoint chargingPoint) {
        this.chargingPoint = chargingPoint;
    }

    public long getDuration() {
        return duration;
    }


    //--------------------Trennstrich--------------------------------- Open alles generierte Getter und Setter, Construktor; Unten sind die Methoden





    // Methode, um den Energie-Typ zu bekommen
    public StationPowerType getPowerType() {
        return chargingPoint.getPowerType();
    }

    public double getEnergyCharged() {
        return energyCharged;
    }

    public double calcTotalPrice() {
        RefillingStation station = chargingPoint.getRefillingStation();


        double pricePerKWh;


        if (getPowerType() == StationPowerType.AC) {
            pricePerKWh = station.getPriceAC();
        } else if (getPowerType() == StationPowerType.DC) {
            pricePerKWh = station.getPriceDC();
        } else {
            throw new IllegalArgumentException("Unknown power type.");
        }


        totalPrice = getEnergyCharged() * pricePerKWh;

        return totalPrice;
    }
}