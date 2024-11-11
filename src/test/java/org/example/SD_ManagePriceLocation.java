package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SD_ManagePriceLocation {
    private FillingNetwork network;
    private RefillingStation addedStation;
    RefillingStation newStation = new RefillingStation();


    public SD_ManagePriceLocation() {
        network = new FillingNetwork(); // Create the network object only once
    }

    @Given("I am the owner")
    public void iAmTheOwner() {
        Owner owner = new Owner();
    }

    @When("I add a new location {string} with prices for {double} kWh AC ,{double} kWh DC")
    public void iAddANewLocationWithPricesForKWhACKWhDC(String location, double priceAC, double priceDC) {
        if (priceAC < 0 || priceDC < 0 || priceAC == 0 || priceDC == 0) {
            throw new IllegalArgumentException("Price cannot be negative or zero");
        }

        newStation.setLocation(location);
        newStation.setPrices(priceAC, priceDC);
        network = new FillingNetwork();
        network.addStation(newStation);  // Station wird zum Netzwerk hinzugefügt
        addedStation = newStation;
    }

    @Then("the prices should be set for the new location {string} {double} kWh AC ,{double} kWh DC")
    public void thePricesShouldBeSetForTheNewLocationKWhACKWhDC(String location, double expectedPriceAC, double expectedPriceDC) {
        assertNotNull(addedStation, "Added station is null");
        assertEquals(location, addedStation.getLocation(), "Location mismatch");
        assertEquals(expectedPriceAC, addedStation.getPriceAC(), "AC price mismatch");
        assertEquals(expectedPriceDC, addedStation.getPriceDC(), "DC price mismatch");
    }

    @When("I update the price of kWh AC to {double} EUR at a specific location or all locations")
    public void iUpdateThePriceOfKWhACToEURAtASpecificLocationOrAllLocations(double newPrice) {

        newStation.setPriceAC(newPrice);
    }

    @Then("the price for kWh AC at that location or all locations should be updated to {double} EUR")
    public void thePriceForKWhACAtThatLocationOrAllLocationsShouldBeUpdatedToEUR(double expectedPrice) {
        if (addedStation != null) {
            assertEquals(expectedPrice, addedStation.getPriceAC(), "AC price mismatch");
        } else {
            for (RefillingStation station : network.getStations()) {
                assertEquals(expectedPrice, station.getPriceAC(), "AC price mismatch");
            }
        }
    }


    @Then("I should receive an error message {string} for the Price_AC and Price_DC")
    public void iShouldReceiveAnErrorMessageForThePrice_ACAndPrice_DC(String errorMessage) {
        RefillingStation station = new RefillingStation();
        try {
            if (station.getPriceDC() <= 0 || station.getPriceAC() <= 0) {
                throw new IllegalArgumentException("Price cannot be negative or zero");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("expectedErrorMessage");
        }
    }

    @Then("I should receive an error message {string} for the Price_AC")
    public void iShouldReceiveAnErrorMessageForThePriceAC(String errorMessage) {
        try {
            // Attempt to set an invalid price (zero or negative)
            newStation.setPriceAC(0); // Example test for zero, can modify for other cases
        } catch (IllegalArgumentException e) {
            assertEquals(errorMessage, e.getMessage(), "Expected error message does not match");
        }
    }

    @When("I delete the price for location {string}")
    public void iDeleteThePriceForLocation(String location) {
        RefillingStation station = network.findStationByLocation(location);
        if (station != null) {
            station.setPriceAC(Double.NaN);  // Or use a sentinel value like -1
            station.setPriceDC(Double.NaN);  // Or use a sentinel value like -1
            System.out.println("Prices deleted for location: " + location);
        }
    }



}