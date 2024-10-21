package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_SetOperatingStatus {
    private ChargingPoint chargingPoint;

    @And("a charging point is currently {string}")
    public void aChargingPointIsCurrently(String status) {
        chargingPoint = new ChargingPoint();
        chargingPoint.setStatus(PointStatus.valueOf(status.toUpperCase().replace(" ", "_")));
    }

    @When("I set the status of the station to {string}")
    public void iSetTheStatusOfTheStationTo(String status) {
        chargingPoint.setStatus(PointStatus.valueOf(status.toUpperCase().replace(" ", "_")));
    }

    @Then("the charging point should be marked as {string}")
    public void theChargingPointShouldBeMarkedAs(String expectedStatus) {
        assert chargingPoint.getStatus().equals(PointStatus.valueOf(expectedStatus.toUpperCase().replace(" ", "_")));
    }

    @When("a customer starts charging")
    public void aCustomerStartsCharging() {
        chargingPoint.startCharging();
    }

    @Then("the charging point should automatically be marked as {string}")
    public void theChargingPointShouldAutomaticallyBeMarkedAs(String expectedStatus) {
        assert chargingPoint.getStatus().equals(PointStatus.valueOf(expectedStatus.toUpperCase().replace(" ", "_")));
    }

    @When("a customer stops charging")
    public void aCustomerStopsCharging() {
        chargingPoint.stopCharging();
    }
}