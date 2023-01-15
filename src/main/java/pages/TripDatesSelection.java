package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseFunctions;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * this class represents the trip date selection page
 * @author Shlomi
 */

public class TripDatesSelection extends BaseFunctions {

	public TripDatesSelection(WebDriver driver) {
		super(driver);
	}

	private String dateTemplate = "//button[@data-hrl-bo='%s'][not(@disabled)]";
	private By departureDate;
	private By returnDate;
	private By nextMonthBTN = By.xpath("//button[@data-hrl-bo='arrow-forward' and(not(contains(@style,'hidden')))]");
	private By nextWizardBTN = By.xpath("//button[@data-hrl-bo='wizard-next-button']");
	private By totalDays = By.xpath("//span[@data-hrl-bo='total-days']");

	public String getStartDate(int daysToAdd) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, daysToAdd);
			String strDate = formatter.format(c.getTime());
			return strDate;
		} catch (Exception e){
			System.out.println("start date is not updated");
		}
		return null;
	}

	public TripDatesSelection selectDepartureDate(int daysToAdd){
		try {
			departureDate = By.xpath(String.format(dateTemplate, getStartDate(daysToAdd)));
			waitForElementToBeClickable(departureDate);
			clickOnElement(departureDate);
		} catch (Exception e){
			System.out.println("departure date is not updated");
		}
		return this;
	}

	public TripDatesSelection selectBackDate(int daysToAdd){
		try {
			returnDate = By.xpath(String.format(dateTemplate, getStartDate(daysToAdd)));
			waitForElementToBeClickable(returnDate);
			clickOnElement(returnDate);
		}catch (Exception e){
			System.out.println("select of the return date was not success");
		}
		return this;
	}

	public TripDatesSelection goToNextMonth(){
		try {
			clickOnElement(nextMonthBTN);
		}
		catch (Exception e){
			System.out.println("next month BTN was not clicked");
		}
		return this;
	}

	public TripDatesSelection clickNextAtWizard(){
		try{
			clickOnElement(nextWizardBTN);
		} catch (Exception e){
			System.out.println("next BTN wizard was not clicked");
		}
		return this;
	}

	public int getTripDuration(){
		try {
			String elementText = getTextFromElement(totalDays);
			String intValue = elementText.replaceAll("[^0-9]", "");
			return Integer.parseInt(intValue);
		} catch (Exception e){
			System.out.println("trip duration is not right");
		}
		return -1;
	}

	public Boolean validateTripDuration(int actualDuration, int expectedDuration){
		return actualDuration >= expectedDuration;
	}

}
