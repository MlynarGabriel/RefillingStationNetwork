package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompareChargingStationsSteps {

    @Given("I am looking for the nearest station")
    public void iAmLookingForNearestStation() {
        // Logik für die Suche nach der nächsten Station
        System.out.println("Suche nach der nächsten Station...");
    }

    @When("I compare stations by distance")
    public void iCompareStationsByDistance() {
        // Logik für den Vergleich der Stationen nach Entfernung
        System.out.println("Vergleiche Stationen nach Entfernung...");
    }

    @Then("the system should display the closest stations first, along with their distances from my location")
    public void systemDisplaysClosestStations() {
        // Logik zum Anzeigen der nächsten Stationen und deren Entfernungen
        System.out.println("Zeige die nächsten Stationen an...");
    }

    @Given("there are several stations in my area")
    public void thereAreSeveralStationsInMyArea() {
        // Logik zum Überprüfen mehrerer Stationen
        System.out.println("Es gibt mehrere Stationen in der Nähe...");
    }

    @When("I compare the prices for kWh AC and DC")
    public void iComparePricesForACDC() {
        // Logik zum Vergleich der Preise für AC und DC
        System.out.println("Vergleiche die Preise für kWh AC und DC...");
    }
    @Then("I should see a list of stations sorted by the cheapest charging rates")
    public void systemDisplaysCheapestChargingRates() {
        // Logik zur Anzeige der günstigsten Ladetarife
        System.out.println("Zeige die günstigsten Ladetarife an...");
    }

    @Given("I need a specific type of charging station")
    public void iNeedSpecificTypeOfStation() {
        // Logik zur Überprüfung des benötigten Lademodells (AC oder DC)
        System.out.println("Spezifischer Ladestationstyp erforderlich...");
    }

    @When("I compare stations by power type")
    public void iCompareStationsByPowerType() {
        // Logik zum Vergleich der Stationen nach Stromtyp
        System.out.println("Vergleiche die Stationen nach Stromtyp...");
    }

    @Then("the system should show me all the available AC or DC stations in the selected area")
    public void systemDisplaysAvailableStationsByPowerType() {
        // Logik zur Anzeige der verfügbaren AC- oder DC-Stationen
        System.out.println("Zeige verfügbare AC- oder DC-Stationen...");
    }
}
