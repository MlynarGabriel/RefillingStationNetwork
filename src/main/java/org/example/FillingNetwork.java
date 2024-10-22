package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillingNetwork {
    private List<RefillingStation> stations;
    private List<Account> customer_accounts;
    private List<Admin_Account> admin_accounts;
    private  List<ChargeSession> chargeSessions;



    public List<ChargeSession> getChargeSessions() {
        return chargeSessions;
    }

    public void setChargeSessions(List<ChargeSession> chargeSessions) {
        this.chargeSessions = chargeSessions;
    }

    public FillingNetwork() {
        stations = new ArrayList<>();
        customer_accounts = new ArrayList<>();
        admin_accounts = new ArrayList<>();
        chargeSessions = new ArrayList<>();
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
    public void addStation(RefillingStation station) {
        System.out.println("Adding station at location: " + station.getLocation());
        stations.add(station);
    }


    public void displayStationStatus(){
        for(RefillingStation s : this.stations){
            System.out.println("Station Location: " + s.getLocation());
            System.out.println("AC Price: " + s.getPriceAC() + " EUR/kWh, DC Price: " + s.getPriceDC() + " EUR/kWh");
            // Add more status information as needed
        }
    }
    // Methode, um eine Station anhand des Standorts zu finden
    public RefillingStation findStationByLocation(String location) {
        for (RefillingStation station : stations) {
            if (station.getLocation().equals(location)) {
                System.out.println("Found station at location: " + location);
                return station;
            }
        }
        System.out.println("No station found at location: " + location);
        return null;
    }
}
