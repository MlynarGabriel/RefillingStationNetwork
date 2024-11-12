package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_StatusChargingPoint {

    private FillingNetwork network;
    private RefillingStation station;
    private ChargingPoint chargingPoint = new ChargingPoint();

    @Given("I view the status of charging points at location {string}")
    public void iViewTheStatusOfChargingPoints(String location) {
        // Initialize the network and station
        network = new FillingNetwork();
        station = network.findStationByLocation(location);
        if (station == null) {
            Assertions.fail("Station not found at location: " + location);
        } else {
            chargingPoint = new ChargingPoint(station);
            Assertions.assertNotNull(chargingPoint, "Charging point should be initialized");
        }
    }

    @When("I check the status of the charging point at location {string}")
    public void iCheckTheStatusOfTheChargingPointAtLocation(String location) {
        if (chargingPoint == null) {
            // Provide a more descriptive message in case the charging point is not initialized
            Assertions.fail("Charging point is not initialized at location: " + location);
        } else {
            PointStatus status = chargingPoint.getStatus();
            Assertions.assertNotNull(status, "Status should not be null");
            System.out.println("Status of charging point at location " + location + ": " + status);
        }
    }


    @Then("I should see the status of the charging point {string}")
    public void iShouldSeeTheStatusOfTheChargingPoint(String expectedStatus) {
        if (chargingPoint != null) {
            PointStatus actualStatus = chargingPoint.getStatus();
            Assertions.assertEquals(PointStatus.valueOf(expectedStatus), actualStatus, "Status should match");
        } else {
            Assertions.fail("Charging point is not initialized");
        }
    }

    @When("I check the power type of a charging point at location {string}")
    public void iCheckThePowerTypeOfAChargingPointAtLocation(String location) {
        if (chargingPoint != null) {
            StationPowerType powerType = chargingPoint.getPowerType();
            Assertions.assertNotNull(powerType, "Power type should not be null");
        } else {
            Assertions.fail("Charging point is not initialized");
        }
    }

    @Then("I should see {string} or {string}")
    public void iShouldSeeOr(String powerType1, String powerType2) {
        if (chargingPoint != null) {
            // Convert the input strings to StationPowerType enum values
            StationPowerType expectedPowerType1 = StationPowerType.valueOf(powerType1);
            StationPowerType expectedPowerType2 = StationPowerType.valueOf(powerType2);

            // Get the actual power type of the charging point
            StationPowerType actualPowerType = chargingPoint.getPowerType();

            // Assert that the actual power type is either of the expected ones (AC or DC)
            Assertions.assertTrue(actualPowerType == expectedPowerType1 || actualPowerType == expectedPowerType2,
                    "Power type should be either " + expectedPowerType1 + " or " + expectedPowerType2);
        } else {
            Assertions.fail("Charging point is not initialized");
        }
    }




    @When("I try to check the status of the charging point at location {string}")
    public void iTryToCheckTheStatusOfTheChargingPointAtLocation(String location) {
        if (chargingPoint == null) {
            Assertions.fail("Charging point is not initialized at location: " + location);
        } else {
            // If status is empty or charging point is in a problematic state
            PointStatus status = chargingPoint.getStatus();
            if (status == null) {
                System.out.println("Status is empty.");
            } else {
                System.out.println("Status: " + status);
            }
        }
    }


    @When("status is empty")
    public void statusIsEmpty() {
        if (chargingPoint != null) {
            // Simulating empty status
            chargingPoint.setStatus(null); // Assuming setStatus is a method of ChargingPoint
            System.out.println("The status is now set to empty.");
        } else {
            Assertions.fail("Charging point is not initialized");
        }
    }


}
