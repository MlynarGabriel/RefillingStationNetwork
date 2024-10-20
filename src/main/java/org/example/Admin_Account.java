package org.example;

public class Admin_Account {

    private int adminId;
    private Owner owner;

    public int getAdminId() {
        return adminId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void changePrices(RefillingStation station) {

    }

    public void addStation(RefillingStation station, FillingNetwork network) {
        network.addStation(station);
    }



}
