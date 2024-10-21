package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_ManagePriceLocation {


    @When("I add a new location {string} with prices for {string} kWh AC ,{string} kWh DC")
    public void iAddANewLocationWithPricesForKWhACKWhDC(String location, String priceAC, String priceDC) {
        RefillingStation newStation = new RefillingStation();
        newStation.setLocation(location);
        newStation.setPrices(Double.parseDouble(priceAC), Double.parseDouble(priceDC));
        FillingNetwork network = new FillingNetwork();
        network.addStation(newStation);  // Station wird zum Netzwerk hinzugefügt
    }

    @Then("the prices should be set for the new location {string} {string} kWh AC ,{string} kWh DC")
    public void thePricesShouldBeSetForTheNewLocationKWhACKWhDC(String arg0, String arg1, String arg2) {
    }

    @When("I update the price of kWh AC to {double} EUR at a location")
    public void iUpdateThePriceOfKWhACToEURAtALocation(int arg0, int arg1) {
    }

    @Then("the price for kWh AC at a location should be {double} EUR")
    public void thePriceForKWhACAtALocationShouldBeEUR(int arg0, int arg1) {
    }

    @And("have multiple locations")
    public void haveMultipleLocations() {
    }

    @When("I set the prices for all locations")
    public void iSetThePricesForAllLocations() {
    }

    @Then("all locations should reflect the new prices")
    public void allLocationsShouldReflectTheNewPrices() {
    }


}
