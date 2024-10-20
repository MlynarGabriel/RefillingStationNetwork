package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SD_PaymentDetails {
    private double topUp;
    private String amount;
    private Account account;

    @When("I enter my payment details and {string} to top up my account")
    public void iEnterMyPaymentDetailsAndToTopUpMyAccount(String amount) {
        this.amount = amount;
        double topUpAmount = Double.parseDouble(amount.replace("€", ""));
        account = new Account();
        account.topUp(topUpAmount);
    }

    @Then("my payment details should be validated")
    public void myPaymentDetailsShouldBeValidated() {
        //hier noch eine überprüfung logik überlegen
        System.out.println("Payment details are valid.");
    }

    @And("my account should be credited with the {string}")
    public void myAccountShouldBeCreditedWithThe(String amount) {
        double expectedAmount = Double.parseDouble(amount.replace("€", ""));
        assertEquals(expectedAmount, account.getBalance());
    }

    @Given("I have entered my payment details")
    public void iHaveEnteredMyPaymentDetails() {
    }

    @When("I confirm the top-up order")
    public void iConfirmTheTopUpOrder() {
    }

    @Then("the system should display a confirmation message with the top-up amount")
    public void theSystemShouldDisplayAConfirmationMessageWithTheTopUpAmount() {
    }

    @Given("I have successfully topped up my account")
    public void iHaveSuccessfullyToppedUpMyAccount() {
    }

    @When("the payment is processed")
    public void thePaymentIsProcessed() {
    }

    @Then("I should receive a notification confirming the payment and the new account balance")
    public void iShouldReceiveANotificationConfirmingThePaymentAndTheNewAccountBalance() {
    }
}
