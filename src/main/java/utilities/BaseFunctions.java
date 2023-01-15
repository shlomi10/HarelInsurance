package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * this class represents the main functions of all pages
 *
 * @author Shlomi
 */


public abstract class BaseFunctions {

	WebDriver driver;
	WebDriverWait wait;
	
	// constructor
	public BaseFunctions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	// function to click on element
	public void clickOnElement(By elem) {
		driver.findElement(elem).click();
	}

		
	// function to wait for element to be clickable
	public void waitForElementToBeClickable(By elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}

	// function to wait for element to be visible
	public void waitForElementToBeVisible(By elem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}

	// function to get text from element
	public String getTextFromElement(By elem) {
		return driver.findElement(elem).getText();
	}

}
