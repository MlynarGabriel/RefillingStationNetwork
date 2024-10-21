package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_SetOperatingStatus {
    private ChargingPoint chargingPoint;
    private Account account= new Account();
    String errorMessage = "";

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

    @When("I try to charge with a balance of zero or below")
    public void iChargeWithABalanceOfZeroOrBelow() {

        try {
            if (account.getBalance() <= 0) {
                throw new IllegalArgumentException("no balance");
            }
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("I should see a error message {string}")
    public void iShouldSeeAErrorMessage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, errorMessage);
    }
}