package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_StatusChargingPoint {
    @When("I view the status of charging point at a location")
    public void iViewTheStatusOfChargingPointAtALocation() {
    }

    @Then("I should see whether each station is {string}, {string}, or {string}")
    public void iShouldSeeWhetherEachPointIsOr(String operation_free, String occupied, String out_of_order) {
    }
}
