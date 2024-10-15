package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvoiceDetailsSteps {

    @Given("I am a registered customer")
    public void iAmRegisteredCustomer() {
        // Logik zur Bestätigung, dass der Benutzer ein registrierter Kunde ist
        System.out.println("Bestätige registrierten Kunden...");
    }

    @When("I check my latest invoice")
    public void iCheckMyLatestInvoice() {
        // Logik zur Überprüfung der letzten Rechnung
        System.out.println("Überprüfe letzte Rechnung...");
    }

    @Then("I should see the details of my most recent charging session including the location, charging point, duration, energy loaded, and total cost")
    public void displayInvoiceDetails() {
        // Logik zur Anzeige der Rechnungsdetails
        System.out.println("Zeige die Details der letzten Ladesitzung an...");
    }

    @When("I check my account balance")
    public void iCheckMyAccountBalance() {
        // Logik zur Überprüfung des Kontostandes
        System.out.println("Überprüfe den Kontostand...");
    }

    @Then("I should see the total balance available and a history of recent top-ups")
    public void displayAccountBalanceAndTopUpHistory() {
        // Logik zur Anzeige des Kontostandes und der Aufladehistorie
        System.out.println("Zeige Kontostand und Aufladehistorie...");
    }
}
