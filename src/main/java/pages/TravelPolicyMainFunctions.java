package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BaseFunctions;


/**
 * this class represents Harel travel policy main page
 *
 * @author Shlomi
 */

public class TravelPolicyMainFunctions extends BaseFunctions {

    // constructor
    public TravelPolicyMainFunctions(WebDriver driver) {
        super(driver);
    }

    By purchaseAtFirstTimeBTN = By.xpath("//div[@class='jss11']");

    // navigate to the site
    public TravelPolicyMainFunctions getWebSite(String site) {
        try{
            getDriver().navigate().to(site);
        } catch (Exception e){
            System.out.println("site is not loaded");
        }
        return this;

    }

    // open first purchase page
    public TravelPolicyMainFunctions openFirstPurchase() {
        try{
            clickOnElement(purchaseAtFirstTimeBTN);
        } catch (Exception e){
            System.out.println("first purchase is not loaded");
        }
        return this;
    }

}
