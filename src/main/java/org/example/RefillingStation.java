package org.example;

import java.util.List;

public class RefillingStation {
    private String location;

    private List<ChargingPoint> chargingPoints;
    private double priceAC= 0.34;//price per kWH
    private double priceDC = 0.44;

    public String displayAC_or_DC_Price() {
        return "AC Price: " + priceAC + " EUR/kWh, DC Price: " + priceDC + " EUR/kWh";
    }

    public double getPriceAC() {
        return priceAC;
    }

    public double getPriceDC() {
        return priceDC;
    }

    public void setPrices(double priceAC, double priceDC) {//für beide ACDC Preise
        this.priceAC = priceAC;
        this.priceDC = priceDC;
    }

    public void addChargingPoint(ChargingPoint point) {
        chargingPoints.add(point);
    }

    public List<ChargingPoint> getChargingPoints() {
        return chargingPoints;
    }

}