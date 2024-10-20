package org.example;

public class ChargingPoint {
    StationStatus status;
    StationPowerType type;


    public ChargingPoint(StationStatus status, StationPowerType type, double priceAC, double priceDC) {
        this.status = status;
        this.type = type;

    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }


    public StationPowerType getPowerType() {
        return type;
    }
    public void setPowerType(StationPowerType type) {
        this.type = type;
    }



}