package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentAndTopUpSteps {

    @Given("I have entered my payment details")
    public void iHaveEnteredMyPaymentDetails() {
        // Logik zur Eingabe der Zahlungsinformationen
        System.out.println("Zahlungsdetails eingegeben...");
    }

    @When("I confirm the top-up order")
    public void iConfirmTheTopUpOrder() {
        // Logik zur Bestätigung der Aufladung
        System.out.println("Bestätige Aufladung...");
    }

    @Then("the system should display a confirmation message with the top-up amount")
    public void systemDisplaysTopUpConfirmation() {
        // Logik zur Anzeige der Bestätigungsnachricht
        System.out.println("Zeige Bestätigungsnachricht der Aufladung...");
    }

    @Given("I have successfully topped up my account")
    public void iHaveSuccessfullyToppedUpMyAccount() {
        // Logik zur Bestätigung einer erfolgreichen Aufladung
        System.out.println("Aufladung erfolgreich...");
    }

    @When("the payment is processed")
    public void paymentIsProcessed() {
        // Logik zur Zahlungsabwicklung
        System.out.println("Zahlung wird bearbeitet...");
    }

    @Then("I should receive a notification confirming the payment and the new account balance")
    public void receivePaymentNotification() {
        // Logik zum Erhalt der Zahlungsbenachrichtigung
        System.out.println("Benachrichtigung zur Zahlung und neuem Kontostand erhalten...");
    }
}
