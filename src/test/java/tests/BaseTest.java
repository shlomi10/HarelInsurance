package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.CountryChoose;
import pages.PassengersDetails;
import pages.TravelPolicyMainFunctions;
import pages.TripDatesSelection;


public class BaseTest implements ITestListener {

    WebDriver driver;
    CountryChoose countryChoose;
    TripDatesSelection tripDatesSelection;
    TravelPolicyMainFunctions travelPolicyMainPage;
    PassengersDetails passengersDetails;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setup(String browser) {

        try {
            if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("IE")) {
                driver = new InternetExplorerDriver();
            }
        } catch (Exception e) {
            System.out.println("You enter wrong browser");
        }

        // maximize the browser window
        driver.manage().window().maximize();

        tripDatesSelection = new TripDatesSelection(driver);
        travelPolicyMainPage = new TravelPolicyMainFunctions(driver);
        countryChoose = new CountryChoose(driver);
        passengersDetails = new PassengersDetails(driver);

    }

    @AfterTest(alwaysRun = true)
    public void close() {
        driver.quit();

    }

}
