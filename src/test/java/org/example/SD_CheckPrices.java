package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class SD_CheckPrices {

    private FillingNetwork network;
    private Account customer_account;
    private Admin_Account admin_account;
    private RefillingStation currentStation;
    private RefillingStation currentStation1;
    private RefillingStation currentStation2;

    @Given("I am a registered customer or the owner")
    public void iAmARegisteredCustomerOrTheOwner() { //initialise accounts and network
        network = new FillingNetwork();
        customer_account = new Account();
        admin_account = new Admin_Account();
    }

    @When("I look up the location {string}")
    public void iLookUpTheLocation(String location) {
        currentStation = network.findStationByLocation(location);
        if (currentStation != null) {
            System.out.println("Station gefunden: " + currentStation.getLocation());
        } else {
            System.out.println("No station found at this location.");
        }
    }



    @Then("I should see the price for all available power types at location {string}")
    public void iShouldSeeThePriceForAllAvailablePowerTypesAtLocation(String location) {
        if (currentStation != null) {
            System.out.println(currentStation.displayAC_or_DC_Price());
        } else {
            System.out.println("No station found at this location.");
        }
    }

    @When("I view the prices for two locations {string} and {string}")
    public void iViewThePricesForTwoLocationsAnd(String location1, String location2) {
        RefillingStation station1 = network.findStationByLocation(location1);
        RefillingStation station2 = network.findStationByLocation(location2);

        if (station1 != null) {
            System.out.println("Location 1: " + station1.displayAC_or_DC_Price());
        } else {
            System.out.println("No station found at location: " + location1);
        }

        if (station2 != null) {
            System.out.println("Location 2: " + station2.displayAC_or_DC_Price());
        } else {
            System.out.println("No station found at location: " + location2);
        }
    }

    @Then("I should see the price differences between the two {string} and {string} locations for kWh AC, kWh DC")
    public void iShouldSeeThePriceDifferencesBetweenTheTwoAndLocationsForKWhACKWhDC(String location1, String location2) {
        RefillingStation station1 = network.findStationByLocation(location1);
        RefillingStation station2 = network.findStationByLocation(location2);

        if (station1 != null && station2 != null) {
            double priceDiffAC = station1.getPriceAC() - station2.getPriceAC();
            double priceDiffDC = station1.getPriceDC() - station2.getPriceDC();

            System.out.println("Price differences:");
            System.out.println("AC: " + priceDiffAC);
            System.out.println("DC: " + priceDiffDC);
        } else {
            System.out.println("No stations found at these locations.");
        }
    }

    @Then("I should see the price {string} for DC at location {string}")
    public void i_should_see_the_price_for_dc_at_location(String expectedPrice, String location) {
        // Assuming you have a method to find the price for DC at the location
        if (currentStation != null) {
            double actualPrice = currentStation.getPriceDC();
            if (String.valueOf(actualPrice).equals(expectedPrice)) {
                System.out.println("Price matches for DC: " + expectedPrice);
            } else {
                System.out.println("Price does not match. Expected: " + expectedPrice + ", Actual: " + actualPrice);
            }
        } else {
            System.out.println("No station found at location: " + location);
        }
    }

    @When("the price is not set")
    public void the_price_is_not_set() {
        // Handle the case where no price is set for DC (use -1 to signify an unset price)
        if (currentStation != null) {
            currentStation.setPriceDC(-1.0);  // Set price to -1.0 to indicate it's not set
            System.out.println("Price is not set for DC at this station.");
        }
    }


    @When("the price for DC at location {string} is set to {double} EUR")
    public void the_price_for_dc_at_location_is_set_to_eur(String location, double price) {
        // Assuming you have a method to find the station by location
        currentStation = network.findStationByLocation(location);
        if (currentStation != null) {
            currentStation.setPriceDC(price);  // price is now a primitive double
            System.out.println("Price for DC at location " + location + " set to " + price + " EUR.");
        } else {
            System.out.println("No station found at location: " + location);
        }
    }
}
