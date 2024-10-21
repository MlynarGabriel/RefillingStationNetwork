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
    public void iAmANewUser() { }

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
        assert registrationProcessed : "The registration was not processed successfully!";
        System.out.println("Registration successful.");

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
        validateRegistration();
    }
    private boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }
    private boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z0-9 ]+$"); // Erlaubt nur Buchstaben, Zahlen und Leerzeichen
    }

    @Then("the system should display an error message asking for the missing details")
    public void theSystemShouldDisplayAnErrorMessageAskingForTheMissingDetails() {
        if (!registrationProcessed) {
            String errorMessage = "Error messages: ";

            if (name == null) {
                errorMessage += "Name is missing. ";
            }
            if (email == null) {
                errorMessage += "Email is missing. ";
            }
            if (password == null) {
                errorMessage += "Password is missing. ";
            }
            System.out.println(errorMessage);
        } else {

            System.out.println("No error messages.");

            assert !registrationProcessed : "There should be an error message!";
        }


    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 255;
    }


    @When("I enter my name, an invalid email and a password  into the registration form")
    public void iEnterMyNameAnInvalidEmailAndAPasswordIntoTheRegistrationForm() {
        name = "TestUser";
        email = "invalid-email"; // nicht gültige E-Mail
        password = "password123";
        validateRegistration();
    }

    @Then("my registration should not be processed")
    public void myRegistrationShouldNotBeProcessed() {
        assert !registrationProcessed : "Registration should not have been processed!";
        System.out.println("Registration was not processed as expected.");
    }

    @When("I attempt to register with missing fields")
    public void iAttemptToRegisterWithMissingFields() {
        registrationProcessed = false; // Setze auf false, da wir die Registrierung testen
        System.out.println("Attempting to register with missing fields...");
        validateRegistration();
    }
    private void displayErrorMessagesForMissingDetails() {
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

        assert !registrationProcessed : "There should be an error message!";
    }

    private void validateRegistration() {
        if (isStringEmpty(name)) {
            System.out.println("Error: Name is missing.");
            registrationProcessed = false;
        }
        if (isStringEmpty(email)) {
            System.out.println("Error: Email is missing.");
            registrationProcessed = false;
        }
        if (isStringEmpty(password)) { // Hier die Überprüfung hinzufügen
            System.out.println("Error: Password is missing.");
            registrationProcessed = false;
        } else if (password.length() < 8) {
            System.out.println("Error: Password is too short.");
            registrationProcessed = false;
        }
        if (!isValidEmail(email)) {
            System.out.println("Error: Invalid email address.");
            registrationProcessed = false;
        }
        if (!isValidName(name)) {
            System.out.println("Error: Name contains invalid characters.");
            registrationProcessed = false;
        }

        // Überprüfe, ob die Registrierung nicht verarbeitet wurde
        assert !registrationProcessed : "There should be an error message!";
    }


    @Then("the system should display an error message indicating that the name is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatTheNameIsMissing() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for missing name, but registration was processed.");
        }
    }

    @And("the system should display an error message indicating that the email is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatTheEmailIsMissing() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for missing email, but registration was processed.");
        }
    }

    @And("the system should display an error message indicating that the password is missing")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatThePasswordIsMissing() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for missing password, but registration was processed.");
        }
        if (password == null) {
            System.out.println("Error: Password is missing.");
        }
    }

    @When("I enter my name, an invalid email, and a valid password into the registration form")
    public void iEnterMyNameAnInvalidEmailAndAValidPasswordIntoTheRegistrationForm() {
        name = "TestUser";
        email = "invalid-email"; // Ungültige E-Mail
        password = "password123";
        registrationProcessed = false; // Registrierung ist nicht erfolgreich
        System.out.println("Name, invalid email, and password have been entered.");
    }

    @And("the system should display an error message for the invalid email")
    public void theSystemShouldDisplayAnErrorMessageForTheInvalidEmail() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for invalid email, but registration was processed.");
        }
    }

    @When("I enter my name, a valid email, and a short password into the registration form")
    public void iEnterMyNameAValidEmailAndAShortPasswordIntoTheRegistrationForm() {
        name = "TestUser";
        email = "test@mail.com";
        password = "zukurz"; // zu kurzes Passwort
        validateRegistration();
    }

    @And("the system should display an error message indicating that the password is too short")
    public void theSystemShouldDisplayAnErrorMessageIndicatingThatThePasswordIsTooShort() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for short password, but registration was processed.");
        }
    }

    @When("I enter a name containing invalid characters, a valid email, and a valid password")
    public void iEnterANameContainingInvalidCharactersAValidEmailAndAValidPassword() {
        name = "Test@User"; // Ungültiger Name
        email = "test@mail.com";
        password = "password123";
        validateRegistration(); // überprüft Registrierung
    }

    @And("the system should display an error message for invalid characters in the name")
    public void theSystemShouldDisplayAnErrorMessageForInvalidCharactersInTheName() {
        if (registrationProcessed) {
            System.out.println("Error: Expected an error message for invalid characters in name, but registration was processed.");
        }
    }
}