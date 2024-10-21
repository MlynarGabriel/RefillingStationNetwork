package org.example;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_RegistrationDetails {

    private boolean registrationProcessed = false;
    private String customerId;
    private String email;
    private String name;
    private String password;

    @Given("I am a new user")
    public void iAmANewUser() {
        System.out.println("Ein neuer Benutzer wurde erstellt.");
    }

    @When("I enter my name, email, and password into the registration form")
    public void iEnterMyNameEmailAndPasswordIntoTheRegistrationForm() {
        name = "TestUser";
        email = "test@mail.com";
        password = "password123";
        registrationProcessed = true;  // Die Registrierung wird hier simuliert
        System.out.println("Name, E-Mail und Passwort wurden eingegeben.");
    }

    @Then("my registration should be processed")
    public void myRegistrationShouldBeProcessed() {
        //überprüft, ob die Registrierung bearbeitet wurde
        if (registrationProcessed) {
            System.out.println("Registration successful.");
        } else {
            throw new RuntimeException("Registration failed.");
        }
        assert registrationProcessed : "The registration was not processed successfully!";
    }

    @And("I should receive a unique customer ID")
    public void iShouldReceiveAUniqueCustomerID() {
        customerId = "CUSTOMER" + System.currentTimeMillis();  // Generiert Id
    }

    @Given("I have successfully registered")
    public void iHaveSuccessfullyRegistered() {
        registrationProcessed = true;
        customerId = "CUSTOMER123456";
        email = "test@mail.com";
        System.out.println("User has successfully registered.");
    }

    @When("the registration is completed")
    public void theRegistrationIsCompleted() {
        System.out.println("Registration completed.");
    }

    @Then("I should receive a confirmation email with my unique customer ID")
    public void iShouldReceiveAConfirmationEmailWithMyUniqueCustomerID() {
        if (email != null && customerId != null) {
            System.out.println("Confirmation email sent to " + email + " with customer ID: " + customerId);
        } else {
            throw new RuntimeException("Error: No confirmation email sent.");
        }
    }

    @Given("I have not entered all required fields")
    public void iHaveNotEnteredAllRequiredFields() {
        name = null; //Name fehlt
        email = null; //Mail fehlt
        password = "password123";  //Passwort wurde aber eingetragen
        registrationProcessed = false;
        System.out.println("Some required fields have not been filled in.");
    }

    @When("I attempt to register")
    public void iAttemptToRegister() {
        if (name == null || email == null || password == null) { //nichts eingegeben
            registrationProcessed = false;
            System.out.println("Registration failed. Missing fields.");
        } else if (!isValidEmail(email)) { //Mail ungültig
            registrationProcessed = false;
            System.out.println("Registration failed. Invalid email address.");
        } else if (password.length() < 8) { //Passwort zu kurz
            registrationProcessed = false;
            System.out.println("Registration failed. Password too short.");
        } else {
            registrationProcessed = true;
        }
    }

    @Then("the system should display an error message asking for the missing details")
    public void theSystemShouldDisplayAnErrorMessageAskingForTheMissingDetails() {
        if (!registrationProcessed) {
            System.out.println("Error message: Please fill out all required fields. ");
        } else {
            System.out.println("No error message.");
        }
        assert !registrationProcessed : "There should have been an error message!";
    }
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 255;
    }

}
