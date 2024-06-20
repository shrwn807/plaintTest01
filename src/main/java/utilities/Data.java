package utilities;

import java.util.Locale;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.github.javafaker.Faker;

public class Data extends Controls {

	WebDriver driver;
	static Locale locale = new Locale("en-US");
	static Faker faker = new Faker(locale);
	
	public Data(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static String defaultUrl = "https://jupiter.cloud.planittesting.com/#/";
	
	public static String firstName() {
		return faker.name().firstName();
	}
	
	public static String emailAddress() {
		return faker.internet().emailAddress();
	}
	
	public static String randomAlphanumeric(String pretext, int length) {
		String randomText = RandomStringUtils.randomAlphanumeric(length);
		return pretext + randomText;
	}
	
	public static String getValue(WebElement element) {
		return element.getText();
	}
	
}
