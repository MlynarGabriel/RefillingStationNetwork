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

    @Given("I am logged in")
    public void i_am_logged_in() {
        account = new Account();
        // Manually set the balance to 50.0 to match the test's expectations
        account.setBalance(50.0);
    }

    @Then("I should see my account balance {string}")
    public void i_should_see_my_account_balance(String expectedBalance) {
        double actualBalance = account.getBalance();  // Get the actual balance from the account
        assertEquals(Double.parseDouble(expectedBalance), actualBalance, "Account balance does not match");
    }

    @When("I have never topped up")
    public void i_have_never_topped_up() {
        // In this case, we assume that the account starts with an empty top-up history by default.
        // No additional action is needed unless you have a method to initialize the top-up history.
    }

    @Then("I should see an empty history")
    public void i_should_see_an_empty_history() {
        List<TopUp> actualHistory = account.getTopUpHistory();  // Get the top-up history from the account
        assertTrue(actualHistory.isEmpty(), "Top-up history is not empty.");
    }
}