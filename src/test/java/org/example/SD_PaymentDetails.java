package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_PaymentDetails {
    @When("I enter my payment details and {string} to top up my account")
    public void iEnterMyPaymentDetailsAndToTopUpMyAccount(String arg0) {
    }

    @Then("my payment details should be validated")
    public void myPaymentDetailsShouldBeValidated() {
    }

    @And("my account should be credited with the {string}")
    public void myAccountShouldBeCreditedWithThe(String arg0) {
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
