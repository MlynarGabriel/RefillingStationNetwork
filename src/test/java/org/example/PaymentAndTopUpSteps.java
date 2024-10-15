package org.example;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentAndTopUpSteps {

    Account account = new Account(); // Starting balance

    @Given("I have entered my payment details")
    public void iHaveEnteredMyPaymentDetails() {
        // Simulate entering payment details
    }

    @When("I enter my payment details and {string} to top up my account")
    public void iEnterMyPaymentDetailsAndToTopUpMyAccount(String amountStr) {
        double amount = Double.parseDouble(amountStr.replace("€", ""));
        account.topUp(amount);
    }

    @Then("my payment details should be validated")
    public void myPaymentDetailsShouldBeValidated() {
        // Here you would implement validation logic
        assertTrue(account.getBalance() > 0);
    }

    @Then("my account should be credited with the {string}")
    public void myAccountShouldBeCreditedWithThe(String amountStr) {
        double expectedAmount = Double.parseDouble(amountStr.replace("€", ""));
        assertEquals(expectedAmount + 100.0, account.getBalance()); // Initial balance was 100.0
    }
}