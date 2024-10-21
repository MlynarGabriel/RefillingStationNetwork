package org.example;

import java.util.ArrayList;
import java.util.List;

public class RefillingStation {
    private String location;

    private List<ChargingPoint> chargingPoints;
    private double priceAC= 0.34;//price per kWH
    private double priceDC = 0.44;

    public RefillingStation(String location, List<ChargingPoint> chargingPoints) {
        this.location = location;
        this.chargingPoints = chargingPoints;
    }

    public RefillingStation() {
        this.chargingPoints = new ArrayList<>();
    }

    public RefillingStation(String location) {
    this.location = location;
    this.chargingPoints = new ArrayList<>();
}


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public void setChargingPoints(List<ChargingPoint> chargingPoints) {
        this.chargingPoints = chargingPoints;
    }

    public double getPriceAC() {
        return priceAC;
    }

    public double getPriceDC() {
        return priceDC;
    }



    public void setPriceAC(double priceAC) {
        this.priceAC = priceAC;
    }

    public void setPriceDC(double priceDC) {
        this.priceDC = priceDC;
    }

    public void setPrices(double priceAC, double priceDC) {//für beide ACDC Preise
        this.priceAC = priceAC;
        this.priceDC = priceDC;
    }



    public String displayAC_or_DC_Price() {
        return "AC Price: " + priceAC + " EUR/kWh, DC Price: " + priceDC + " EUR/kWh";
    }




    public void addChargingPoint(ChargingPoint point) {
        chargingPoints.add(point);
    }

    public List<ChargingPoint> getChargingPoints() {
        return chargingPoints;
    }


}