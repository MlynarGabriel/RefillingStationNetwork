package org.example;

public class RefillingStation {
    String location;
    StationStatus status;
    Double price;

    public RefillingStation(StationStatus status) {
        this.status = status;
    }

    public static void setPrice(double price){
        this.price = price;
    }

    public static void setStatus(StationStatus status){
        this.status = status;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public StationStatus getStatus() {
        return Status;
    }

    public Double getPrice() {
        return price;
    }
}
