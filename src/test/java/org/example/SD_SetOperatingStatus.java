package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SD_SetOperatingStatus {

    private String stationStatus; //aktueller Status einer Ladestation
    private String chargingPointStatus; //aktueller Status eines charging points

    @Given("I am the owner")
    public void iAmTheOwner() {

    }

    @And("a charging station is currently {string}")
    public void aChargingStationIsCurrently(String currentStatus) {
        this.stationStatus = currentStatus;
        System.out.println("Charging station is currently: " + stationStatus);
    }

    @When("I set the status of the station to {string}")
    public void iSetTheStatusOfTheStationTo(String newStatus) throws IllegalArgumentException {
        if (!isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Invalid status: " + newStatus);
        }
        stationStatus = newStatus;
        System.out.println("Station status changed to: " + stationStatus);
    }
    //todo
    @Then("the charging station should be marked as {string}")
    public void theChargingStationShouldBeMarkedAs(String expectedStatus) {
        if (stationStatus.equals(expectedStatus)) {
            System.out.println("Correct: The charging station is now " + expectedStatus + ".");
        } else {
            System.out.println("Incorrect: Expected " + expectedStatus + ", but it is " + stationStatus + ".");
        }
    }


    @When("I set the status to {string}")
    public void iSetTheStatusTo(String newStatus) {
        stationStatus = newStatus;
        System.out.println("Station status changed to: " + stationStatus);
    }

    @When("a customer starts charging")
    public void aCustomerStartsCharging() {
        if (stationStatus.equals("in operation free")) {
            stationStatus = "occupied";
            System.out.println("Customer started charging. Status changed to: occupied.");
        } else {
            throw new IllegalStateException("Error: Station is not available for charging.");
        }
    }

    @Then("the charging station should automatically be marked as {string}")
    public void theChargingStationShouldAutomaticallyBeMarkedAs(String expectedStatus) {
        if (stationStatus.equals(expectedStatus)) {
            System.out.println("Correct: The charging station is now automatically " + expectedStatus + ".");
        } else {
            System.out.println("Incorrect: Expected " + expectedStatus + ", but it is " + stationStatus + ".");
        }
    }

    private boolean isValidStatus(String status) {
        return status.equals("in operation") ||
                status.equals("out of order") ||
                status.equals("in operation free") ||
                status.equals("occupied");
    }

    @And("a charging point is currently {string}")
    public void aChargingPointIsCurrently(String currentPointStatus) {
        this.chargingPointStatus = currentPointStatus;
        System.out.println("Charging point is currently: " + chargingPointStatus);
    }

    @Then("the charging point should be marked as {string}")
    public void theChargingPointShouldBeMarkedAs(String expectedPointStatus) {
        if (chargingPointStatus.equals(expectedPointStatus)) {
            System.out.println("Correct: The charging point is now " + expectedPointStatus + ".");
        } else {
            System.out.println("Incorrect: Expected " + expectedPointStatus + ", but it is " + chargingPointStatus + ".");
        }
    }

        @Then("the charging point should automatically be marked as {string}")
        public void theChargingPointShouldAutomaticallyBeMarkedAs (String expectedPointStatus){
            if (chargingPointStatus.equals(expectedPointStatus)) {
                System.out.println("Correct: The charging point is now automatically " + expectedPointStatus + ".");
            } else {
                System.out.println("Incorrect: Expected " + expectedPointStatus + ", but it is " + chargingPointStatus + ".");
            }
        }
    }

