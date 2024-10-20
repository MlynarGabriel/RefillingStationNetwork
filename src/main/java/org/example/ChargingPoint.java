package org.example;

public class ChargingPoint {
    private RefillingStation refillingStation;
    private StationStatus status;
    private StationPowerType powerType;
    private boolean isAvailable;

    public RefillingStation getRefillingStation() {
        return refillingStation;
    }

    public void setRefillingStation(RefillingStation refillingStation) {
        this.refillingStation = refillingStation;
    }

    public ChargingPoint(StationStatus status, StationPowerType powerType) {
        this.status = status;
        this.powerType = powerType;
        this.isAvailable = status == StationStatus.IN_OPERATION_FREE;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }


    public StationPowerType getPowerType() {
        return powerType;
    }
    public void setPowerType(StationPowerType type) {
        this.powerType = type;
    }


    public boolean startCharging() {
        if (status == StationStatus.IN_OPERATION_FREE) {
            // Ladepunkt als belegt markieren
            status = StationStatus.OCCUPIED;
            isAvailable = false;
            System.out.println("Charging has started.");
            return true;
        } else if (status == StationStatus.OUT_OF_ORDER) {
            // Falls der Ladepunkt außer Betrieb ist, Fehler melden; vllt ab hier später eine ExceptionIO schreiben
            System.out.println("Cannot start charging: Charging point is out of order.");
            return false;
        } else {
            // Falls die Station bereits belegt ist
            System.out.println("Cannot start charging: Charging point is already occupied.");
            return false;
        }
    }
}