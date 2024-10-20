package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillingNetwork {
    private List<RefillingStation> stations;
    private List<Account> customer_accounts;
    private List<Admin_Account> admin_accounts

    public void addStation(RefillingStation station) {
        stations.add(station);
    }



    public List<Account> getCustomer_accounts() {
        return customer_accounts;
    }

    public void setCustomer_accounts(List<Account> customer_accounts) {
        this.customer_accounts = customer_accounts;
    }

    public List<Admin_Account> getAdmin_accounts() {
        return admin_accounts;
    }

    public void setAdmin_accounts(List<Admin_Account> admin_accounts) {
        this.admin_accounts = admin_accounts;
    }


    public void registerCustomer(Customer customer){
        //bearbeiten
    }

    public List<RefillingStation> getStations() {
        return stations;
    }

    public void setStations(List<RefillingStation> stations) {
        this.stations = stations;
    }

    public List<Account> getAccounts() {
        return customer_accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.customer_accounts = accounts;
    }


    //______________trennstrich--------------- getter setter oben, Methode unten


    public void displayStationStatus(){
        for(RefillingStation s : this.stations){
            //bearbeiten
        }
    }
    // Methode, um eine Station anhand des Standorts zu finden
    public RefillingStation findStationByLocation(String location) {
        for (RefillingStation station : stations) {
            if (station.getLocation().equalsIgnoreCase(location)) {
                return station; // Rückgabe der Station, wenn der Standort übereinstimmt
            }
        }
        return null; // Rückgabe von null, wenn keine Station mit dem Standort gefunden wurde
    }
}
