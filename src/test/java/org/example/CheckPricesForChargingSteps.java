package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckPricesForChargingSteps {

    private RefillingStation station; // Declare your station here

    @Given("I am the owner")
    public void iAmTheOwner() {
        // Any additional setup for the owner can be added here if necessary
    }

    @Given("the current price for kWh AC is {double} EUR at a location")
    public void theCurrentPriceForKWhAC(Double price) {
        // Initialize the station with a status and set the price
        station = new RefillingStation(StationStatus.IN_OPERATION);
        station.setPrice(price); // Set initial price for kWh AC
    }

    @When("I update the price of kWh AC to {double} EUR at a location")
    public void iUpdateThePriceOfKWhAC(Double newPrice) {
        // Check if station is initialized
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION); // Initialize if null
        }
        station.setPrice(newPrice); // Update the price
    }

    @Then("the price for kWh AC at a location should be {double} EUR")
    public void thePriceForKWhACAtALocationShouldBeEUR(Double expectedPrice) {
        assertEquals(expectedPrice, station.getPrice()); // Check the updated price
    }

    // For multiple prices changes, we need additional steps

    @Given("the current price for kWh DC is {double} EUR at a location")
    public void theCurrentPriceForKWhDC(Double price) {
        // Initialize the station with a status and set the price
        station = new RefillingStation(StationStatus.IN_OPERATION);
        station.setPrice(price); // Set initial price for kWh DC
    }

    @When("I change the price of kWh DC to {double} EUR in the afternoon")
    public void iChangeThePriceOfKWhDCInTheAfternoon(Double newPrice) {
        // Ensure station is initialized
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION); // Initialize if null
        }
        station.setPrice(newPrice); // Update the price in the afternoon
    }

    @When("I change it again to {double} EUR in the evening")
    public void iChangeItAgainToEURInTheEvening(Double newPrice) {
        // Ensure station is initialized
        if (station == null) {
            station = new RefillingStation(StationStatus.IN_OPERATION); // Initialize if null
        }
        station.setPrice(newPrice); // Update the price in the evening
    }

    @Then("the price of kWh DC should be {double} EUR by the end of the day")
    public void thePriceOfKWhDCShouldBeEURByTheEndOfTheDay(Double expectedPrice) {
        assertEquals(expectedPrice, station.getPrice()); // Check the final price
    }
}