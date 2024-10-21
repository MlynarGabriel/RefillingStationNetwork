package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SD_SetOperatingStatus {

    private String stationStatus = "out of order"; //aktueller Status einer Ladestation
    private String chargingPointStatus = "out of order"; //aktueller Status eines charging points
    public boolean isOwner = false;
    private String errorMessage = "";


    @And("a charging station is currently {string}")
    public void aChargingStationIsCurrently(String currentStatus) {
        this.stationStatus = currentStatus;
        System.out.println("Charging station is currently: " + stationStatus);
    }

    @When("I set the status of the station to {string}")
    public void iSetTheStatusOfTheStationTo(String newStatus)  {
        if (!isOwner) {
            errorMessage = "You do not have permission to change the status.";
        } else if (stationStatus.equals(newStatus)) {
            errorMessage = "The charging station is already in the desired state.";
        } else if (!isValidStatus(newStatus)) {
            errorMessage = "Invalid status: " + newStatus + ".";
        } else {
            stationStatus = newStatus;
            errorMessage = ""; // Fehler zurücksetzen
            System.out.println("Station status changed to: " + stationStatus);
        }
    }

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
        if (!stationStatus.equals("in operation free")) {
            throw new IllegalStateException("Error: Station is not available for charging.");
        }
        stationStatus = "occupied";
        System.out.println("Customer started charging. Status changed to: occupied.");
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
        return status.equals("in operation") || status.equals("out of order") || status.equals("occupied");
    }

    @Given("a charging point is available")
    public void aChargingPointIsAvailable() {
        chargingPointStatus = "in operation free";
        System.out.println("Charging point status set to: " + chargingPointStatus);
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
    public void theChargingPointShouldAutomaticallyBeMarkedAs(String expectedPointStatus) {
        if (chargingPointStatus.equals(expectedPointStatus)) {
            System.out.println("Correct: The charging point is now automatically " + expectedPointStatus + ".");
        } else {
            System.out.println("Incorrect: Expected " + expectedPointStatus + ", but it is " + chargingPointStatus + ".");

        }

    }

    @And("a charging point is currently {string}")
    public void aChargingPointIsCurrently(String currentStatus) {
        stationStatus = currentStatus;
        System.out.println("Charging station is currently: " + stationStatus);
    }

    @Given("I am not the owner")
    public void iAmNotTheOwner() {
        isOwner = false;
    }

    @When("I attempt to set the status of the station to {string}")
    public void iAttemptToSetTheStatusOfTheStationTo(String newStatus) {
        if (!isOwner) {
            errorMessage = "You do not have permission to change the status.";
        } else if (!isValidStatus(newStatus)) {
            errorMessage = "Invalid status: " + newStatus + ".";
        } else if (stationStatus.equals("occupied")) {
            errorMessage = "Cannot change status: Charging point is currently occupied.";
        } else {
            stationStatus = newStatus;
            errorMessage = ""; // Fehler zurücksetzen
            System.out.println("Station status changed to: " + stationStatus);
        }
    }

    @Then("a message should be displayed saying {string}")
    public void aMessageShouldBeDisplayedSaying(String expectedMessage) {
        if (errorMessage.equals(expectedMessage)) {
            System.out.println("Correct: " + expectedMessage);
        } else {
            System.out.println("Incorrect: Expected message '" + expectedMessage + "' but got '" + errorMessage + "'.");
        }
    }

    @Given("I am the owner")
    public void iAmTheOwner() {
        isOwner = true;
    }
}
