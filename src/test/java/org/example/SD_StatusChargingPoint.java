package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_StatusChargingPoint {

    private FillingNetwork network;
    private RefillingStation station;
    private ChargingPoint chargingPoint;

    @Given("I view the status of charging points at location {string}")
    public void iViewTheStatusOfChargingPoints(String location) {
        // Initialize the network and station
        network = new FillingNetwork();
        station = network.findStationByLocation(location); // Replace "location" with the actual location you want to search for
        chargingPoint = new ChargingPoint(station);
    }


}