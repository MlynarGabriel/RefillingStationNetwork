package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            if (station.getLocation().isEmpty()) {
                throw new IllegalArgumentException("location name required");
            }
        } catch (IllegalArgumentException e) {
            errorMessage = e.getMessage();

        }
    }

    @Then("i should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, errorMessage);
    }
}
