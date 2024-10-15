package org.example;

public class ChargingPoint {
    StationStatus status;
    StationPowerType type;
    double priceAC;
    double priceDC;

    public ChargingPoint(StationStatus status, StationPowerType type, double priceAC, double priceDC) {
        this.status = status;
        this.type = type;
        this.priceAC = priceAC;
        this.priceDC = priceDC;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    public StationPowerType getType() {
        return type;
    }

    public void setType(StationPowerType type) {
        this.type = type;
    }

    public double getPriceAC() {
        return priceAC;
    }

    public double getPriceDC() {
        return priceDC;
    }

    public void setPrices(double priceAC, double priceDC) {
        this.priceAC = priceAC;
        this.priceDC = priceDC;
    }
}