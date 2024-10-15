package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckInvoiceDetailsSteps {

    private Account account; // This should be initialized in your setup
    private double expectedBalance; // Store expected balance for validation
    private List<Double> expectedTopUps; // Store expected top-ups for validation

    public CheckInvoiceDetailsSteps() {
        this.account = new Account(); // Initialize account for testing
    }

    @When("I check my account balance")
    public void iCheckMyAccountBalance() {
        // This method is to check the balance,
        // but the balance is usually checked in the following assert step
        // No action needed here if using the getBalance() in the Then step
    }

    @Then("I should see the total balance available and a history of recent top-ups")
    public void iShouldSeeTheTotalBalanceAvailableAndAHistoryOfRecentTopUps() {
        // Validate the balance
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance, "The account balance does not match the expected balance.");

        // Validate the top-up history
        List<Double> actualTopUps = account.getTopUpHistory();
        assertEquals(expectedTopUps, actualTopUps, "The top-up history does not match the expected history.");
    }

    // Method to simulate top-ups for your tests
    public void topUpAccount(double amount) {
        account.topUp(amount);
        expectedBalance += amount;
        expectedTopUps.add(amount);
    }
}