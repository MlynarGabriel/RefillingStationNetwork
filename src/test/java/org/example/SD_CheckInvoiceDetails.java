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
    }

    @Then("I should see the details of my most recent charging session including the location, charging point, duration, energy loaded, and total cost")
    public void iShouldSeeTheDetailsOfMyMostRecentChargingSessionIncludingTheLocationChargingPointDurationEnergyLoadedAndTotalCost() {
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
