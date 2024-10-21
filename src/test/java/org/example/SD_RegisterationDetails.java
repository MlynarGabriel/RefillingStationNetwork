package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_RegisterationDetails {
    private String name;
    private String email;
    private String password;
    private boolean registrationSuccessful;
    private String errorMessage;

    @Given("I am a new user")
    public void iAmANewUser() {
        // Initialize the user's details
        name = "";
        email = "";
        password = "";
    }

    @When("I enter my name, email, and password into the registration form")
    public void iEnterMyNameEmailAndPasswordIntoTheRegistrationForm() {
        // Simulate entering the user's details into the registration form
        name = "John Doe";
        email = "johndoe@example.com";
        password = "password123";
    }

    @Then("my registration should be processed")
    public void myRegistrationShouldBeProcessed() {
        // Simulate processing the registration
        registrationSuccessful = true;
    }

    @And("I should receive a unique customer ID")
    public void iShouldReceiveAUniqueCustomerID() {
        // Simulate generating a unique customer ID
        String customerId = "CUST-12345";
        System.out.println("Customer ID: " + customerId);
    }

    @Given("I have not entered all required fields")
    public void iHaveNotEnteredAllRequiredFields() {
        // Simulate not entering all required fields
        name = "";
        email = "johndoe@example.com";
        password = "";
    }

    @When("I attempt to register")
    public void iAttemptToRegister() {
        // Simulate attempting to register
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errorMessage = "Please enter all required fields";
        } else {
            registrationSuccessful = true;
        }
    }

    @Then("the system should display an error message asking for the missing details")
    public void theSystemShouldDisplayAnErrorMessageAskingForTheMissingDetails() {
        // Simulate displaying the error message
        if (errorMessage != null) {
            System.out.println("Error: " + errorMessage);
        }
    }
}