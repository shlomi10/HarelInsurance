package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseFunctions;


/**
 * this class represents the country's option to choose
 * @author Shlomi
 */

public class CountryChoose extends BaseFunctions {

	// constructor
	public CountryChoose(WebDriver driver) {
		super(driver);
	}

	By countryUSA = By.xpath("//div[@data-hrl-bo='USA']");
	
	// choose the first country
	public CountryChoose chooseFirstCountry() {
		try {
			waitForElementToBeClickable(countryUSA);
			clickOnElement(countryUSA);
		} catch (Exception e){
			System.out.println(" country USA was not chose");
		}
		return this;
	}
}