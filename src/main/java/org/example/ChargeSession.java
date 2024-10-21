package org.example;

public class ChargeSession {

    private long duration;  // in minutes
    private double energyCharged;
    private double totalPrice;
    private Account account;
    private ChargingPoint chargingPoint;

    public ChargeSession() {
        this.duration = 60;  // Example duration
        this.energyCharged = 20.0;  // Example energy in kWh
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
    public PowerType getPowerType() {
        return chargingPoint.getPowerType(); //wir nehmen den Powertyp von der ChargingPoint Klasse
    }

    public double getEnergyCharged() {
        return energyCharged;
    }

    public double calcTotalPrice() {
        RefillingStation station = chargingPoint.getRefillingStation();

        // Preis pro kWh abhängig vom Power-Typ (AC oder DC)
        double pricePerKWh;

        // Überprüfen, welcher Power-Typ verwendet wird (AC oder DC)
        if (getPowerType() == PowerType.AC) {
            pricePerKWh = station.getPriceAC(); // Preis pro kWh für AC von der RefillingStation
        } else if (getPowerType() == PowerType.DC) {
            pricePerKWh = station.getPriceDC(); // Preis pro kWh für DC von der RefillingStation
        } else {
            throw new IllegalArgumentException("Unknown power type.");
        }

        // Berechnung des Gesamtpreises: Energieverbrauch (kWh) * Preis pro kWh
        totalPrice = getEnergyCharged() * pricePerKWh;

        return totalPrice;
    }
}