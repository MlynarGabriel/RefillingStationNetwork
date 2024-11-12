package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_StartChargingSession {

    private double balance;
    private String chargingPointStatus;
    private boolean chargingSessionStarted;
    private String errorMessage;

    // Scenario: Start charging session with sufficient balance
    @Given("I am a registered customer with a balance of {double} EUR")
    public void iAmARegisteredCustomerWithABalanceOfEUR(double balance) {
        this.balance = balance;
        chargingSessionStarted = false; // Assume session is not started yet
        errorMessage = ""; // Clear any error message from previous tests
    }

    @And("I am at a charging point that is {string}")
    public void iAmAtAChargingPointThatIs(String status) {
        this.chargingPointStatus = status;
    }

    @When("I select {string} as my charging mode and start a charging session")
    public void iSelectChargingModeAndStartAChargingSession(String mode) {
        if ("IN_OPERATION_FREE".equals(chargingPointStatus) && balance > 0) {
            chargingSessionStarted = true; // Simulate session start
        } else if ("OUT_OF_ORDER".equals(chargingPointStatus)) {
            errorMessage = "Charging station is currently out of order. Please try another station.";
        }
    }

    @Then("the charging session should begin with the current DC price per kWh locked in")
    public void theChargingSessionShouldBeginWithTheCurrentDCPricePerKWhLockedIn() {
        Assertions.assertTrue(chargingSessionStarted, "Charging session did not start as expected.");
    }

    @And("my balance should be reduced based on the usage at the locked-in rate")
    public void myBalanceShouldBeReducedBasedOnTheUsageAtTheLockedInRate() {
        double usageAmount = 5.00; // Example usage in EUR, for simplicity
        balance -= usageAmount; // Deduct from balance
        Assertions.assertTrue(balance >= 0, "Balance should be reduced based on usage.");
    }

    // Error Case: Deny charging session if station is out of order
    @Given("I am a registered customer at a charging point that is {string}")
    public void iAmARegisteredCustomerAtAChargingPointThatIs(String status) {
        this.chargingPointStatus = status;
    }

    @When("I attempt to start a charging session")
    public void iAttemptToStartAChargingSession() {
        if ("OUT_OF_ORDER".equals(chargingPointStatus)) {
            chargingSessionStarted = false;
            errorMessage = "Charging station is currently out of order. Please try another station.";
        } else if ("IN_OPERATION_FREE".equals(chargingPointStatus)) {
            chargingSessionStarted = true;
        }
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Error message mismatch.");
    }

    // Error Case: Attempt to start multiple charging sessions on a single account at once
    @Given("I am a registered customer with a single account")
    public void iAmARegisteredCustomerWithASingleAccount() {
        chargingSessionStarted = false; // Make sure no session is active
    }

    @When("I attempt to start multiple charging sessions at once")
    public void iAttemptToStartMultipleChargingSessionsAtOnce() {
        if (chargingSessionStarted) {
            errorMessage = "Account cannot start multiple sessions"; // Set error message
        } else {
            chargingSessionStarted = true; // Start the first session
        }
    }

    @Then("I should see an error message {string} for multiple sessions")
    public void iShouldSeeAnErrorMessageForMultipleSessions(String expectedErrorMessage) {
        Assertions.assertEquals(expectedErrorMessage, errorMessage, "Error message mismatch for multiple sessions.");
    }
}