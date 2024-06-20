package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Assertions extends Controls {
	
	WebDriver driver;

	public Assertions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static void assertIsDisplayed(WebElement element, Boolean scriptState) {
		Boolean isPresent = false;
		if (element == null) {
			isPresent = false;
		} else {
			try {
				if (element.isDisplayed()) {
					isPresent = true;
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
		}
		if (scriptState) {
			Assert.assertTrue(isPresent, "Element is not Displayed on the page");
		} else {
			Assert.assertFalse(isPresent, "Element is Displayed on the page");
		}
	}
	
	public static void assertText(WebElement element, String expected) {
		String text = element.getText();
		Assert.assertEquals(text, expected, "Assertion FAILED: ");
	}
	
	public static void assertEquals(double actual, double expected) {
		Assert.assertEquals(actual, expected, "Assertion FAILED: ");
	}
	
}
