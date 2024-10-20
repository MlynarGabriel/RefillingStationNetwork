package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_CheckInvoiceDetails {
    private Account account;

    @Given("I am a registered customer")
    public void iAmARegisteredCustomer() {
        account = new Account();
        account.setBalance(0.0);
    }

    @When("I check my invoices")
    public void iCheckMyInvoices() {
        // Angenommen, die `ChargeSession`-Daten stehen hier zur Verfügung:
        ChargeSession session = new ChargeSession(); // Das würde normalerweise von einer vorherigen Ladesitzung gesetzt.
        // session.setStart(), session.setEnd(), etc. sollten vorher definiert sein.
        double totalPrice = session.calcTotalPrice();
        System.out.println("Total price: " + totalPrice);
    }

    @Then("I should see the details of my most recent charging session including the location, charging point, duration, energy loaded, and total cost")
    public void iShouldSeeTheDetailsOfMyMostRecentChargingSessionIncludingTheLocationChargingPointDurationEnergyLoadedAndTotalCost() {
        ChargeSession session = new ChargeSession();  // Normalerweise würde dies die letzte Sitzung sein
        long duration = session.getDuration();
        double energy = session.getEnergyCharged();
        String location = session.getChargingPoint().getRefillingStation().getLocation();

        System.out.println("Location: " + location);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Energy: " + energy + " kWh");
        System.out.println("Total cost: " + session.calcTotalPrice() + " EUR");
    }

    @When("I check my account balance")
    public void iCheckMyAccountBalance() {
    }

    @Then("I should see the total balance available")
    public void iShouldSeeTheTotalBalanceAvailable() {
    }

    @When("I check my account top-up history")
    public void iCheckMyAccountTopUpHistory() {
    }

    @Then("I should see a history of recent top-ups, including dates and amounts")
    public void iShouldSeeAHistoryOfRecentTopUpsIncludingDatesAndAmounts() {
    }
}
