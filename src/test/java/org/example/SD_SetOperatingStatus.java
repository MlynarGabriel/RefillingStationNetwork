package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_SetOperatingStatus {
    @And("a charging station is currently {string}")
    public void aChargingStationIsCurrently(String arg0) {
    }

    @When("I set the status of the station to {string}")
    public void iSetTheStatusOfTheStationTo(String arg0) {
    }

    @Then("the charging station should be marked as {string}")
    public void theChargingStationShouldBeMarkedAs(String arg0) {
    }

    @When("I set the status to {string}")
    public void iSetTheStatusTo(String arg0) {
    }

    @When("a customer starts charging")
    public void aCustomerStartsCharging() {
    }

    @Then("the charging station should automatically be marked as {string}")
    public void theChargingStationShouldAutomaticallyBeMarkedAs(String arg0) {
    }
}
