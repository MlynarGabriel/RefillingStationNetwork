package org.example;

import java.util.Date;

public class ChargeSession {
    Date start;
    Date end;
    StationPowerType powerType;
    double energyCharged; // in kWh
    double totalPrice;

    public ChargeSession(Date start, Date end, StationPowerType powerType, double energyCharged, double totalPrice) {
        this.start = start;
        this.end = end;
        this.powerType = powerType;
        this.energyCharged = energyCharged;
        this.totalPrice = totalPrice;
    }

    public long getDuration() {
        return (end.getTime() - start.getTime()) / 60000; // duration in minutes
    }

    public StationPowerType getPowerType() {
        return powerType;
    }

    public double getEnergyCharged() {
        return energyCharged;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}