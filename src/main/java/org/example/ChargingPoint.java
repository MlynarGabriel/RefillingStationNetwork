package org.example;

public class ChargingPoint {
    private RefillingStation refillingStation = new RefillingStation();
    private PointStatus status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
    private StationPowerType powerType =  StationPowerType.AC; //default setting to AC
    private boolean isAvailable;


    public ChargingPoint() {
        this.refillingStation = new RefillingStation(); // Initialize refillingStation
        this.status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
        this.powerType = StationPowerType.AC; //default setting to AC
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }


    public ChargingPoint(RefillingStation refillingStation) {
        this.refillingStation = refillingStation;
        this.status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
        this.powerType = StationPowerType.AC; //default setting to AC
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }


    public ChargingPoint(RefillingStation refillingStation, PointStatus status, StationPowerType powerType) {
        this.refillingStation = refillingStation;
        this.status = status;
        this.powerType = powerType;
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }


    public ChargingPoint(RefillingStation refillingStation, PointStatus status, StationPowerType powerType, boolean isAvailable) {
        this.refillingStation = refillingStation;
        this.status = status;
        this.powerType = powerType;
        this.isAvailable = isAvailable;
    }

    public RefillingStation getRefillingStation() {
        return refillingStation;
    }

    public void setRefillingStation(RefillingStation refillingStation) {
        this.refillingStation = refillingStation;
    }



    public PointStatus getStatus() {
        return status;
    }

    public void setStatus(PointStatus status) {
        this.status = status;
    }


    public StationPowerType getPowerType() {
        return powerType;
    }
    public void setPowerType(StationPowerType type) {
        this.powerType = type;
    }


//.-----------------------------------------

    public boolean isAvailable() {
        if (status == PointStatus.IN_OPERATION_FREE) {
            return true;
        }  else { //if OUT_OF_ORDER or OCCUPIED
            return false;
        }

    }

    public boolean startCharging() {
        if (status == PointStatus.IN_OPERATION_FREE) {

            status = PointStatus.OCCUPIED;
            isAvailable = false;
            System.out.println("Charging has started.");
            return true;
        } else if (status == PointStatus.OUT_OF_ORDER) {

            System.out.println("Charging point is out of order.");
            return false;
        } else {

            System.out.println("Charging point is already occupied.");
            return false;
        }
    }

    public boolean stopCharging() {
        if (status == PointStatus.OCCUPIED) {

            status = PointStatus.IN_OPERATION_FREE;
            isAvailable = true;
            System.out.println("Charging has stopped.");
            return true;
        } else if (status == PointStatus.OUT_OF_ORDER) {

            System.out.println("Charging point is out of order.");
            return false;
        } else {

            System.out.println("Charging point is already available.");
            return false;
        }
    }
}