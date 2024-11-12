package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class SD_PaymentDetails {

    private Account account = new Account();
    private double topupAmount;
    private double initialBalance;
    private double newBalance;
    private FillingNetwork network = new FillingNetwork();


    @And("I have an account with balance of {double} EUR")
    public void iHaveAnAccountWithBalanceOfEUR(double initialBalance) {
        account.setBalance(initialBalance);
    }

    @When("I top up my account with {double} EUR")
    public void iTopUpMyAccountWith(double topupAmount) {
        account.topUp(topupAmount);

    }

    @Then("my account balance should be updated")
    public void myAccountBalanceShouldBeUpdated() {

    }

    @And("I should see my new balance as {double} EUR")
    public void iShouldBeAbleToViewMyNewBalance(double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance(), 0.01);
    }


    @Then("I should receive an error message {string}")
    public void iShouldReceiveAnErrorMessage(String expectedErrorMessage) {
        RefillingStation station = new RefillingStation();

        try {
            // Validate prices before adding the location
            if (topupAmount <= 0 ) {
                throw new IllegalArgumentException("Price cannot be negative or zero");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("expectedErrorMessage");
        }

    }

    @When("I top up my account with {int}{int}{int} EUR")
    public void iTopUpMyAccountWithEUR(int arg0, int arg1, int arg2) {
        // Combine the integers into a decimal value representing the top-up
        double combinedTopUpAmount = arg0 + (arg1 / 10.0) + (arg2 / 100.0);
        account.topUp(combinedTopUpAmount);
    }


    @And("I should see my new balance as {int}{int}{int} EUR")
    public void iShouldSeeMyNewBalanceAsEUR(int arg0, int arg1, int arg2) {
        // Combine the integers into the expected new balance
        double expectedBalance = arg0 + (arg1 / 10.0) + (arg2 / 100.0);
        assertEquals(expectedBalance, account.getBalance(), 0.01);
    }





}