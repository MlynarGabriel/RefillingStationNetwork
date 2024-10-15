package org.example;

import java.util.HashMap;
import java.util.Map;

public class FillingNetwork {
    Map<String, ChargingPoint> stations;

    public FillingNetwork() {
        this.stations = new HashMap<>();
    }

    public void addStation(String location, ChargingPoint station) {
        stations.put(location, station);
    }

    public ChargingPoint getStation(String location) {
        return stations.get(location);
    }

    public void setStationPrices(String location, double priceAC, double priceDC) {
        ChargingPoint station = stations.get(location);
        if (station != null) {
            station.setPrices(priceAC, priceDC);
        }
    }
}