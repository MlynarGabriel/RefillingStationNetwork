package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_AddRefillingStation {

    RefillingStation station = new RefillingStation();


    @When("I add a new refilling station at location {string}")
    public void iAddANewRefillingStationAtLocation(String location) {
        station = new RefillingStation(); // create a new RefillingStation object
        station.setLocation(location);


    }

    @Then("the refilling station should be created at location {string}")
    public void theRefillingStationShouldBeCreatedAtLocation(String expectedLocation) {

        Assertions.assertEquals(expectedLocation, station.getLocation());

    }
}
