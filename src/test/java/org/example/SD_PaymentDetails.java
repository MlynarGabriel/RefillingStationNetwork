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
        // No implementation needed, as this is already verified in the next step
    }

    @And("I should see my new balance as {double} EUR")
    public void iShouldBeAbleToViewMyNewBalance(double expectedBalance) {
        assertEquals(expectedBalance, account.getBalance(), 0.01);
    }
}
