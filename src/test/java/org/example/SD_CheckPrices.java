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

}
