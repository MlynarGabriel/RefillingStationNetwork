package org.example;

import java.time.Duration;
import java.util.Date;

public class ChargeSession {
    private Date start;
    private Date end;
    private double energyCharged;
    private double totalPrice;
    private Account account;
    private ChargingPoint chargingPoint;



    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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


    //--------------------Trennstrich--------------------------------- Open alles generierte Getter und Setter, Construktor; Unten sind die Methoden



    public long getDuration() {
        return (end.getTime() - start.getTime()) / (1000 * 60); // Dauer in Minuten
    }

    // Methode, um den Energie-Typ zu bekommen
    public StationPowerType getPowerType() {
        return chargingPoint.getPowerType(); //wir nehmen den Powertyp von der ChargingPoint Klasse
    }

    public double getEnergyCharged() {
        return energyCharged;
    }

    public double calcTotalPrice() {
        // bearbeiten;Überlegen wir wir den Preis berechnen hier
    }
}