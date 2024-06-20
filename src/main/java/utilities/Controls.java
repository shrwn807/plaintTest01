package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Controls {

	public static WebDriver driver;
	public final static int waitForElementTimeout = 15;
	public Controls(WebDriver driver) {
		Controls.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static WebDriverWait webDriverWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitForElementTimeout));
		return wait;
	}
	
	public static void waitForAngularRequest() {
		try {
			JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
			NgWebDriver ngDriver = new NgWebDriver(jsDriver);
			ngDriver.waitForAngularRequestsToFinish();
		} catch (Exception e) {
			System.out.println("Error while waiting for Angular request to finish");
		}
	}
	
	public static void waitForElementToBeClickable(WebElement element) {
		webDriverWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementToBeVisible(WebElement element) {
		try {
			webDriverWait().until(ExpectedConditions.visibilityOf(element));
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not visible after " + waitForElementTimeout +  "seconds: " + e.getMessage());
		}
	}
	
	public static void waitForInvisibilityOfElement(WebElement element) {
		webDriverWait().until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static WebElement findElement(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			return element;
		} catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
			System.out.println("   Element with xpath [" + xpath + "] is not Present");
			return null;
		}
	}
	
	public static void click(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public static void sendKeys(WebElement element, String value) {
		waitForElementToBeVisible(element);
		click(element);
		element.sendKeys(value);
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	public static Double convertStringToDouble(WebElement element) {
		String itemPrice = Data.getValue(element);
		String formattedPrice = itemPrice.replaceAll("[^0-9\\.]", "");
		return Double.valueOf(formattedPrice);
	}
	
	
}
