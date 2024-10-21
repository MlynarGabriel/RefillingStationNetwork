package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SD_CheckInvoiceDetails {
    private Account account;
    private ChargeSession session;

    @Given("I am a registered customer")
    public void iAmARegisteredCustomer() {
        account = new Account();//initialize account und außerdem hat ein registered customer ein Account

    }

    @When("I access my account information")
    public void iAccessMyAccountInformation() {
        session = new ChargeSession();



        double totalPrice = session.calcTotalPrice();
        System.out.println("Total price: " + totalPrice);
    }

    @Then("I should see my account balance and the details of my most recent charging session")
    public void iShouldSeeMyAccountBalanceAndTheDetailsOfMyMostRecentChargingSession() {
        long duration = session.getDuration();
        double energy = session.getEnergyCharged();
        String location = session.getChargingPoint().getRefillingStation().getLocation();

        System.out.println("Account balance: " + account.getBalance());
        System.out.println("Location: " + location);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Energy: " + energy + " kWh");
        System.out.println("Total cost: " + session.calcTotalPrice() + " EUR");
    }

    @When("I check my account top-up history")
    public void iCheckMyAccountTopUpHistory() {
        List<TopUp> topUpHistory = account.getTopUpHistory(); // Example method in Account class
        for (TopUp topUp : topUpHistory) {
            System.out.println("Top-up on " + topUp.getDate() + ": " + topUp.getAmount() + " EUR");
        }
    }

    @Then("I should see a history of recent top-ups, including dates and amounts")
    public void iShouldSeeAHistoryOfRecentTopUpsIncludingDatesAndAmounts() {
        // Get the actual top-up history from the account
        List<TopUp> actualHistory = account.getTopUpHistory();

        // Since we haven't added any top-ups in this test, the history should be empty
        assertTrue(actualHistory.isEmpty(), "Top-up history is not empty.");
        }

}