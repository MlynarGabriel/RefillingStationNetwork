package org.example;

public class RefillingStation {
    String location;
    StationStatus status;
    Double price;

    public RefillingStation(StationStatus status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    // Fixing the typo here by changing 'Status' to 'status'
    public StationStatus getStatus() {
        return status; // Use 'status' instead of 'Status'
    }

    public Double getPrice() {
        return price;
    }
}