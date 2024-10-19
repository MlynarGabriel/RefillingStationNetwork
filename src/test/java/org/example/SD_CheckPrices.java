package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_CheckPrices {
    @Given("I am a registered customer or the owner")
    public void iAmARegisteredCustomerOrTheOwner() {
    }

    @When("I look up the location {string}")
    public void iLookUpTheLocation(String arg0) {
    }

    @Then("I should see the price for all available power types at location {string}")
    public void iShouldSeeThePriceForAllAvailablePowerTypesAtLocation(String arg0) {
    }

    @When("I view the prices for multiple locations {string} and {string}")
    public void iViewThePricesForMultipleLocationsAnd(String arg0, String arg1) {
    }

    @Then("I should see the price differences between the two {string} and {string} locations for kWh AC, kWh DC, and per-minute charging rates")
    public void iShouldSeeThePriceDifferencesBetweenTheTwoAndLocationsForKWhACKWhDCAndPerMinuteChargingRates(String arg0, String arg1) {
    }
}
