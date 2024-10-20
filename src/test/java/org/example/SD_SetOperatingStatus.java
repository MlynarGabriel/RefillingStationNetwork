package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import javax.swing.text.Position;

public class SD_SetOperatingStatus {
    private ChargingPoint chargingPoint;

    @And("a charging point is currently {string}")
    public void aChargingPointIsCurrently( String status) {

        chargingPoint.setStatus(StationStatus.valueOf(status));
    }

    @When("I set the status of the station to {string}")
    public void iSetTheStatusOfTheStationTo(String status) {
    }

    @Then("the charging point should be marked as {string}")
    public void theChargingPointShouldBeMarkedAs(String expectedStatus) {
        assert chargingPoint.getStatus().equals(StationStatus.valueOf(expectedStatus));
    }

    @When("I set the status to {string}")
    public void iSetTheStatusTo(String status) {
        chargingPoint.setStatus(StationStatus.valueOf(status));
    }

    @When("a customer starts charging")
    public void aCustomerStartsCharging() { //true_false Methode
        chargingPoint.startCharging();
    }

    @Then("the charging point should automatically be marked as {string}")
    public void theChargingPointShouldAutomaticallyBeMarkedAs(String expectedStatus) {
        assert chargingPoint.getStatus().equals(StationStatus.valueOf(expectedStatus));
    }
}
