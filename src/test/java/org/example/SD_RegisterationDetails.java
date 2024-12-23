package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_RegisterationDetails {
    private String name;
    private String email;
    private String password;
    private boolean registrationSuccessful = false;
    private String errorMessage;

    @Given("I am a new user")
    public void iAmANewUser() {
        name = "";
        email = "";
        password = "";
    }

    @Then("my registration should be processed")
    public void myRegistrationShouldBeProcessed() {
        // Simulate processing the registration
        registrationSuccessful = true;
    }

    @And("I should receive a unique customer ID")
    public void iShouldReceiveAUniqueCustomerID() {
        String customerId = "CUST-12345";
        System.out.println("Customer ID: " + customerId);
    }

    @Given("I have not entered all required fields")
    public void iHaveNotEnteredAllRequiredFields() {
        name = "";
        email = "johndoe@example.com";
        password = "";
    }


    @Then("the system should display an error message asking for the missing details")
    public void theSystemShouldDisplayAnErrorMessageAskingForTheMissingDetails() {
        if (errorMessage != null) {
            System.out.println("Error: " + errorMessage);
        }
    }

    @When("I attempt to register with missing fields")
    public void iAttemptToRegisterWithMissingFields() {
        registrationSuccessful = false;
        System.out.println("Attempting to register with missing fields...");
        validateRegistration();
    }

    private boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }


    private void validateRegistration() {
        if (isStringEmpty(name)) {
            System.out.println("Error: Name is missing.");
            registrationSuccessful = false;
        }
        if (isStringEmpty(email)) {
            System.out.println("Error: Email is missing.");
            registrationSuccessful = false;
        }
        if (isStringEmpty(password)) { // Hier die Überprüfung hinzufügen
            System.out.println("Error: Password is missing.");
            registrationSuccessful = false;
        } else if (password.length() < 8) {
            System.out.println("Error: Password is too short.");
            registrationSuccessful = false;
        }
        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email address.");
            registrationSuccessful = false;
        }
        if (!isValidName(name)) {
            System.out.println("Error: Name contains invalid characters.");
            registrationSuccessful = false;
        }


        assert !registrationSuccessful : "There should be an error message!";
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 255;
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z0-9 ]+$");
    }

    @Then("the system should display an error message indicating that the name is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatTheNameIsMissing() {
        if (registrationSuccessful) {
            System.out.println("Error: Expected an error message for missing name, but registration was processed.");
        }
    }

    @And("the system should display an error message indicating that the email is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatTheEmailIsMissing() {
        if (registrationSuccessful) {
            System.out.println("Error: Expected an error message for missing email, but registration was processed.");
        }
    }

    @And("the system should display an error message indicating that the password is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatThePasswordIsMissing() {
        if (registrationSuccessful) {
            System.out.println("Error: Expected an error message for missing password, but registration was processed.");
        }
        if (password == null) {
            System.out.println("Error: Password is missing.");
        }
    }


    @Then("my registration should not be processed")
    public void myRegistrationShouldNotBeProcessed() {
        assert !registrationSuccessful : "Registration should not have been processed!";
        System.out.println("Registration was not processed as expected.");
    }

    @And("the system should display an error message for the invalid email")
    public void theSystemShouldDisplayAnErrorMessageForTheInvalidEmail() {
        StringBuilder errorMessage = new StringBuilder("Error messages: ");
        boolean hasError = false;

        if (isStringEmpty(name)) {
            errorMessage.append("Name is missing. ");
            hasError = true;
        }
        if (isStringEmpty(email)) {
            errorMessage.append("Email is missing. ");
            hasError = true;
        }
        if (isStringEmpty(password)) {
            errorMessage.append("Password is missing. ");
            hasError = true;
        }

        if (hasError) {
            System.out.println(errorMessage.toString().trim());
        } else {
            System.out.println("No missing fields.");
        }

        assert !registrationSuccessful : "There should be an error message!";
    }


    @When("I enter {string} as a name, {string} as the email address, and {string} as a password into the registration form")
    public void iEnterAsANameAsTheEmailAddressAndAsAPasswordIntoTheRegistrationForm(String name, String email, String passwort) {
        this.name = name;
        this.email = email;
        this.password = password;
        validateRegistration();
    }

    @Then("the system should display an error message {string}")
    public void the_system_should_display_an_error_message(String errorMessage) {
        System.out.println("Error: " + errorMessage);
        registrationSuccessful = false;
    }

    @When("I enter {string} as a name, {string} as the email address, and {string} as a password")
    public void i_enter_as_a_name_as_the_email_address_and_as_a_password(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        validateRegistration();
    }

    @And("the system should display an error message your mail is missing the @.")
    public void theSystemShouldDisplayAnErrorMessageYourMailIsMissingThe() throws Throwable {
        if (!email.contains("@")) {
            System.out.println("Fehler: Ihre E-Mail fehlt das @.");
            registrationSuccessful = false;
        }}

    @When("I  enter {string} as a name, {string} as the email address, and {string} as a password")
    public void iEnterAsANameAsTheEmailAddressAndAsAPassword(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        validateRegistration();

    }

}