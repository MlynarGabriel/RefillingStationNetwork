package org.example;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SD_CheckPrices {

    private FillingNetwork network;
    private Account customer_account;
    private Admin_Account admin_account;

    @Given("I am a registered customer or the owner")
    public void iAmARegisteredCustomerOrTheOwner() {

    }

    @When("I look up the location {string}")
    public void iLookUpTheLocation(String location) {
        RefillingStation station = network.findStationByLocation(location);
        if (station != null) {
            System.out.println("Station gefunden: " + station.getLocation());
        } else {
            System.out.println("Keine Station an diesem Standort gefunden.");
        }
    }



    @Then("I should see the price for all available power types at location {string}")
    public void iShouldSeeThePriceForAllAvailablePowerTypesAtLocation(String location) {
        RefillingStation station = network.findStationByLocation(location);
        if (station != null) {
            System.out.println(station.displayAC_or_DC_Price());
        } else {
            System.out.println("Keine Station an diesem Standort gefunden.");
        }
    }

    @When("I view the prices for multiple locations {string} and {string}")
    public void iViewThePricesForMultipleLocationsAnd(String arg0, String arg1) {
    }

    @Then("I should see the price differences between the two {string} and {string} locations for kWh AC, kWh DC, and per-minute charging rates")
    public void iShouldSeeThePriceDifferencesBetweenTheTwoAndLocationsForKWhACKWhDCAndPerMinuteChargingRates(String location1, String location2) {
        RefillingStation station1 = findStationByLocation(location1);
        RefillingStation station2 = findStationByLocation(location2);

        System.out.println("Location 1: " + station1.displayAC_or_DC_Price());
        System.out.println("Location 2: " + station2.displayAC_or_DC_Price());
    }


}
