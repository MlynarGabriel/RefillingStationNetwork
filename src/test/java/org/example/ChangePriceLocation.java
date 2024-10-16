package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangePriceLocation {

    private RefillingStation station;

    @Given("I am the owner")
    public void iAmTheOwner() {
    }

    @Given("the current price for kWh AC is {double} EUR at a location")
    public void theCurrentPriceForKWhAC(Double price) {
        station = new RefillingStation(StationStatus.IN_OPERATION);
        station.setPrice(price); // Set price for kWh AC
    }

    @When("I update the price of kWh AC to {double} EUR at a location")
    public void iUpdateThePriceOfKWhAC(Double newPrice) {
        // Check if station is initialized
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION);
        }
        station.setPrice(newPrice);
    }

    @Then("the price for kWh AC at a location should be {double} EUR")
    public void thePriceForKWhACAtALocationShouldBeEUR(Double expectedPrice) {
        assertEquals(expectedPrice, station.getPrice());
    }


    @Given("the current price for kWh DC is {double} EUR at a location")
    public void theCurrentPriceForKWhDC(Double price) {
        station = new RefillingStation(StationStatus.IN_OPERATION);
        station.setPrice(price); // Set initial price for kWh DC
    }

    @When("I change the price of kWh DC to {double} EUR in the afternoon")
    public void iChangeThePriceOfKWhDCInTheAfternoon(Double newPrice) {
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION);
        }
        station.setPrice(newPrice);
    }

    @When("I change it again to {double} EUR in the evening")
    public void iChangeItAgainToEURInTheEvening(Double newPrice) {
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION);
        }
        station.setPrice(newPrice);
    }

    @Then("the price of kWh DC should be {double} EUR by the end of the day")
    public void thePriceOfKWhDCShouldBeEURByTheEndOfTheDay(Double expectedPrice) {
        assertEquals(expectedPrice, station.getPrice());
    }
}