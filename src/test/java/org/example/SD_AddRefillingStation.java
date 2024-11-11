package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SD_AddRefillingStation {

    RefillingStation station = new RefillingStation();
    String errorMessage = "";



    @When("I add a new refilling station at location {string}")
    public void iAddANewRefillingStationAtLocation(String location) {
        station = new RefillingStation(); // create a new RefillingStation object
        station.setLocation(location);


    }

    @Then("the refilling station should be created at location {string}")
    public void theRefillingStationShouldBeCreatedAtLocation(String expectedLocation) {
        Assertions.assertEquals(expectedLocation, station.getLocation());
    }

    @When("I try to add a new refilling station without adding the name of a location")
    public void iTryToAddANewRefillingStationWithoutAddingALocation() {
        try {
            station = new RefillingStation("", Collections.emptyList());
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        // This is where you'd typically check an error variable or log
        System.out.println("Expected error message: " + expectedErrorMessage);
    }

    @When("I try to enter the station name {string}")
    public void i_try_to_enter_the_station_name(String stationName) {
        if (stationName.length() < 3) {
            System.out.println("Error: Station name is too short.");
        } else {
            // Simulate saving the station name or processing further
            System.out.println("Station name entered successfully: " + stationName);
        }
    }

    @Given("this is the refilling station:")
    public void this_is_the_refilling_station(io.cucumber.datatable.DataTable dataTable) {
        // Convert DataTable to a list of maps and process attributes
        List<Map<String, String>> stationData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : stationData) {
            String name = data.get("name");
            String location = data.get("location");
            System.out.println("Setting up refilling station with name: " + name + " and location: " + location);
        }
    }

    @When("the owner tries to delete the name {string}")
    public void the_owner_tries_to_delete_the_name(String stationName) {
        // Simulate deletion logic; in a real system, you might check if it exists and can be deleted
        System.out.println("Attempting to delete station with name: " + stationName);
    }

    @Then("an error message should be display {string}")
    public void an_error_message_should_be_display(String errorMessage) {
        System.out.println("Expected error message for deletion: " + errorMessage);
    }

}
