package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SD_ManageCustomerAccount {
    private String currentPassword = "pwd12345";
    private boolean accountDeleted = false;
    private String errorMessage = null;

    @When("I want to change my password to {string}")
    public void iWantToChangeMyPasswordTo(String newPassword) {
        if (newPassword.length() < 4) {
            errorMessage = "the password too short";
        } else if (newPassword.equals(currentPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        } else {
            currentPassword = newPassword;
            errorMessage = null; // Clear any previous error messages
        }
    }

    @And("the previous password is not {string}")
    public void thePreviousPasswordIsNot(String oldPassword) {
        if (currentPassword.equals(oldPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        }
    }

    @Then("the password will be change to {string}")
    public void thePasswordWillBeChangeTo(String expectedPassword) {
        assertEquals(expectedPassword, currentPassword, "Password was not changed correctly");
    }

    @When("I want to delete my account")
    public void iWantToDeleteMyAccount() {

        accountDeleted = true;
    }

    @Then("my account should be deleted")
    public void myAccountShouldBeDeleted() {
        assertTrue(accountDeleted, "Account was not deleted");
    }

    @When("I try to change my password to {string}")
    public void iTryToChangeMyPasswordTo(String newPassword) {
        if (newPassword.length() < 4) {
            errorMessage = "the password too short";
        } else if (newPassword.equals(currentPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        } else {
            currentPassword = newPassword;
            errorMessage = null;
        }
    }

    @And("the new password is the same as the old password {string}")
    public void theNewPasswordIsTheSameAsTheOldPassword(String oldPassword) {
        if (currentPassword.equals(oldPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        }
    }


    @Then("an error message should be displayed {string}")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        assertEquals(expectedErrorMessage, errorMessage, "Error message mismatch");
    }
}