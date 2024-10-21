package org.example;

public class ChargingPoint {
    private RefillingStation refillingStation = new RefillingStation();
    private PointStatus status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
    private StationPowerType powerType =  StationPowerType.AC; //default setting to AC
    private boolean isAvailable;

    // No-arg constructor
    public ChargingPoint() {
        this.refillingStation = new RefillingStation(); // Initialize refillingStation
        this.status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
        this.powerType = StationPowerType.AC; //default setting to AC
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }

    // Constructor with RefillingStation
    public ChargingPoint(RefillingStation refillingStation) {
        this.refillingStation = refillingStation;
        this.status = PointStatus.IN_OPERATION_FREE; //default setting to in operation free
        this.powerType = StationPowerType.AC; //default setting to AC
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }

    // Constructor with RefillingStation, StationStatus, and StationPowerType
    public ChargingPoint(RefillingStation refillingStation, PointStatus status, StationPowerType powerType) {
        this.refillingStation = refillingStation;
        this.status = status;
        this.powerType = powerType;
        this.isAvailable = status == PointStatus.IN_OPERATION_FREE;
    }

    // Constructor with RefillingStation, StationStatus, StationPowerType, and isAvailable
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
            // Ladepunkt als occupied updaten und isAvailable auf false setzen
            status = PointStatus.OCCUPIED;
            isAvailable = false;
            System.out.println("Charging has started.");
            return true;
        } else if (status == PointStatus.OUT_OF_ORDER) {
            // Falls der Ladepunkt out of order ist, Fehler melden; vllt ab hier später eine ExceptionIO schreiben
            System.out.println("Charging point is out of order.");
            return false;
        } else {
            // Falls die Station bereits occupied ist, ist aber etwas unnötig weil die Person es ja physisch sehen kann wenn der dort ist. aber ja machen wir es so wieso nicht
            System.out.println("Charging point is already occupied.");
            return false;
        }
    }

    public boolean stopCharging() {
        if (status == PointStatus.OCCUPIED) {
            // Ladepunkt als in operation free updaten und isAvailable auf true setzen
            status = PointStatus.IN_OPERATION_FREE;
            isAvailable = true;
            System.out.println("Charging has stopped.");
            return true;
        } else if (status == PointStatus.OUT_OF_ORDER) {
            // Falls der Ladepunkt out of order ist, Fehler melden
            System.out.println("Charging point is out of order.");
            return false;
        } else {
            // Falls die Station bereits in operation free ist, ist aber etwas unnötig weil die Person es ja physisch sehen kann wenn der dort ist. aber ja machen wir es so wieso nicht
            System.out.println("Charging point is already available.");
            return false;
        }
    }
}