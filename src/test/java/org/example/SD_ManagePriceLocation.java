package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SD_ManagePriceLocation {
    private FillingNetwork network;
    private RefillingStation addedStation;

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

        RefillingStation newStation = new RefillingStation();
        newStation.setLocation(location);
        newStation.setPrices(priceAC, priceDC);
        network = new FillingNetwork();
        network.addStation(newStation);  // Station wird zum Netzwerk hinzugefügt
        addedStation = newStation;
    }

    @Then("the prices should be set for the new location {string} {double} kWh AC ,{double} kWh DC")
    public void thePricesShouldBeSetForTheNewLocationKWhACKWhDC(String location, double expectedPriceAC, double expectedPriceDC) {
        assertNotNull(addedStation, "Added station is null");
        assertEquals(location, addedStation.getLocation());
        assertEquals(expectedPriceAC, addedStation.getPriceAC(), "AC price mismatch");
        assertEquals(expectedPriceDC, addedStation.getPriceDC(), "DC price mismatch");
    }

    @When("I update the price of kWh AC to {double} EUR at a specific location or all locations")
    public void iUpdateThePriceOfKWhACToEURAtASpecificLocationOrAllLocations(double newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (addedStation != null) {
            addedStation.setPriceAC(newPrice);
        } else {
            for (RefillingStation station : network.getStations()) {
                station.setPriceAC(newPrice);
            }
        }
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
}