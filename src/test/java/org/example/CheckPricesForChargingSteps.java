package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckPricesForChargingSteps {

    @Given("I am a registered customer or the owner")
    public void iAmRegisteredCustomerOrOwner() {
        // Logik zur Überprüfung, ob der Benutzer ein registrierter Kunde oder Besitzer ist
        System.out.println("Überprüfe registrierten Kunden oder Besitzer...");
    }

    @When("I view the prices for a location")
    public void iViewPricesForALocation() {
        // Logik zur Anzeige der Preise für einen bestimmten Standort
        System.out.println("Zeige Preise für einen bestimmten Standort an...");
    }

    @Then("I should see the price for all available power types")
    public void displayPricesForAllPowerTypes() {
        // Logik zur Anzeige der Preise für alle verfügbaren Stromtypen
        System.out.println("Zeige Preise für alle Stromtypen...");
    }

    @When("I view the prices for multiple locations")
    public void iViewPricesForMultipleLocations() {
        // Logik zur Anzeige der Preise für mehrere Standorte
        System.out.println("Zeige Preise für mehrere Standorte an...");
    }

    @Then("I should see the price differences between the two locations for kWh AC, kWh DC, and per-minute charging rates")
    public void displayPriceDifferencesBetweenLocations() {
        // Logik zur Anzeige der Preisunterschiede zwischen Standorten
        System.out.println("Zeige Preisunterschiede zwischen den Standorten an...");
    }
}
