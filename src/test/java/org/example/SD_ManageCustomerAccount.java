package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SD_ManageCustomerAccount {
    private String currentPassword = "pwd12345"; // Simulated initial password for the registered customer
    private boolean accountDeleted = false; // Flag to indicate account status
    private String errorMessage = null; // To store error messages

    @When("I want to change my password to {string}")
    public void iWantToChangeMyPasswordTo(String newPassword) {
        // Attempt to change password if it meets basic criteria
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
        // Ensure the new password does not match the old password
        if (currentPassword.equals(oldPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        }
    }

    @Then("the password will be change to {string}")
    public void thePasswordWillBeChangeTo(String expectedPassword) {
        // Verify that the password was successfully changed
        assertEquals(expectedPassword, currentPassword, "Password was not changed correctly");
    }

    @When("I want to delete my account")
    public void iWantToDeleteMyAccount() {
        // Mark the account as deleted
        accountDeleted = true;
    }

    @Then("my account should be deleted")
    public void myAccountShouldBeDeleted() {
        // Confirm that the account deletion was successful
        assertTrue(accountDeleted, "Account was not deleted");
    }

    @When("I try to change my password to {string}")
    public void iTryToChangeMyPasswordTo(String newPassword) {
        // Attempt to change the password with validation for short length and same password
        if (newPassword.length() < 4) {
            errorMessage = "the password too short";
        } else if (newPassword.equals(currentPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        } else {
            currentPassword = newPassword;
            errorMessage = null; // Reset error message if password change is successful
        }
    }

    @And("the new password is the same as the old password {string}")
    public void theNewPasswordIsTheSameAsTheOldPassword(String oldPassword) {
        // Check if the new password is identical to the old password
        if (currentPassword.equals(oldPassword)) {
            errorMessage = "New password cannot be the same as the old password";
        }
    }


    @Then("an error message should be displayed {string}")
    public void anErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        // Similar validation to check if the expected error message appears
        assertEquals(expectedErrorMessage, errorMessage, "Error message mismatch");
    }
}