package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseFunctions;

/**
 * this class represents the passengers page details
 *
 * @author Shlomi
 */

public class PassengersDetails extends BaseFunctions {

    public PassengersDetails(WebDriver driver) {
        super(driver);
    }

    private By travelerInfoTitle = By.xpath("//span[@data-hrl-bo='traveler_info_0']");

    public Boolean isTitleDisplayed() {
        try{
            waitForElementToBeVisible(travelerInfoTitle);
            return getTextFromElement(travelerInfoTitle) != null;
        }
        catch (Exception e){
            System.out.println("Element not found at travelers page");
        }
        return false;
    }

}


