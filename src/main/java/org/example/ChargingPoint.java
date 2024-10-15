package org.example;

public class ChargingPoint {
    StationStatus status;
    StationPowerType type;

    public ChargingPoint(StationStatus status, StationPowerType type) {
        this.status = status;
        this.type = type;
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
}
