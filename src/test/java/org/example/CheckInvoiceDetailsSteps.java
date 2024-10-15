package org.example;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckInvoiceDetailsSteps {

    private Account account;
    private double expectedBalance;
    private List<Double> expectedTopUps;

    public CheckInvoiceDetailsSteps() {
        this.account = new Account();
    }

    @When("I check my account balance")
    public void iCheckMyAccountBalance() {
        //empty bc checked in then
    }

    @Then("I should see the total balance available and a history of recent top-ups")
    public void iShouldSeeTheTotalBalanceAvailableAndAHistoryOfRecentTopUps() {
        double actualBalance = account.getBalance();
        assertEquals(expectedBalance, actualBalance, "The account balance does not match the expected balance.");

        List<Double> actualTopUps = account.getTopUpHistory();
        assertEquals(expectedTopUps, actualTopUps, "The top-up history does not match the expected history.");
    }


    public void topUpAccount(double amount) {
        account.topUp(amount);
        expectedBalance += amount;
        expectedTopUps.add(amount);
    }
}