package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SD_StartChargingSession {
    private Account account;
    private ChargingPoint chargingPoint;
    private String chargingMode;
    private double dcPricePerKWh;
    private String errorMessage;
    @Given("I am a register customer with a balance of {double} EUR")
    public void iAmARegisterCustomerWithABalanceOfEUR(double initialBalance) {
        account = new Account();
        account.setBalance(initialBalance);
    }

    @And("I am at a charging point that is {string}")
    public void iAmAtAChargingPointThatIs(String status) {
        chargingPoint = new ChargingPoint();
        chargingPoint.setStatus(PointStatus.valueOf(status.toUpperCase().replace(" ", "_")));
    }

    @When("I select {string} as my charging mode and start a charging session")
    public void iSelectAsMyChargingModeAndStartAChargingSession(String mode) {
        chargingMode = mode;
        dcPricePerKWh = 0.5;
        if (chargingPoint.getStatus() != PointStatus.IN_OPERATION_FREE) {
            errorMessage = "Charging station is currently out of order. Please try another station.";
            return;
        }

        if (account.getBalance() == 0) {
            errorMessage = "Insufficient balance. Please top up your account.";
            return;
        }

        if (account.getBalance() >= dcPricePerKWh) {

            account.setBalance(account.getBalance() - dcPricePerKWh);
        } else {
            errorMessage = "Insufficient balance for the selected charging mode.";
        }
    }

    @Then("the charging session should begin with the current DC price per kWh locked in")
    public void theChargingSessionShouldBeginWithTheCurrentDCPricePerKWhLockedIn() {
        Assertions.assertNull(errorMessage, "Error while starting the charging session: " + errorMessage);
        Assertions.assertEquals("DC", chargingMode, "Charging mode mismatch.");
        System.out.println("Charging session started with mode " + chargingMode + " at " + dcPricePerKWh + " EUR per kWh.");
    }

    @And("my balance should be reduced based on the usage at the locked-in rate")
    public void myBalanceShouldBeReducedBasedOnTheUsageAtTheLockedInRate() {

        double expectedBalance = 69.00 - dcPricePerKWh; // Assuming initial balance was 69.00 EUR
        Assertions.assertEquals(expectedBalance, account.getBalance(), "Balance after charging doesn't match.");
    }

    @Given("I am a registered customer at a charging point that is {string}")
    public void iAmARegisteredCustomerAtAChargingPointThatIs(String status) {
        account = new Account();
        account.setBalance(69.00);
        chargingPoint = new ChargingPoint();
        chargingPoint.setStatus(PointStatus.valueOf(status.toUpperCase().replace(" ", "_")));
    }

    @When("I attempt to start a charging session")
    public void iAttemptToStartAChargingSession() {
        if (chargingPoint.getStatus() == PointStatus.OUT_OF_ORDER) {
            errorMessage = "Charging station is currently out of order. Please try another station.";
        } else if (account.getBalance() == 0) {
            errorMessage = "Insufficient balance to start a charging session.";
        }
    }



}
