package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * this class represents the test runner
 * @author Shlomi
 */

public class MainRunner extends BaseTest {

	String siteURL = "https://digital.harel-group.co.il/travel-policy";
	int daysTolDeparture = 7;
	int daysToFlyBack = 37;
	int expectedDuration = 30;

	@Test(priority = 1, description = "flight insurance purchase")
	public void assignmentTest() {
		travelPolicyMainPage.getWebSite(siteURL).openFirstPurchase();
		countryChoose.chooseFirstCountry();
		tripDatesSelection.selectDepartureDate(daysTolDeparture).goToNextMonth().selectBackDate(daysToFlyBack);
		Assert.assertTrue(tripDatesSelection.validateTripDuration(tripDatesSelection.getTripDuration(), expectedDuration), "Total days are not more or equal 30");
		tripDatesSelection.clickNextAtWizard();
		Assert.assertTrue(passengersDetails.isTitleDisplayed(), "passengers details page not loaded correct");
	}

}
