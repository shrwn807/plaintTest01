package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeTest
    public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(Data.defaultUrl);
    }
	
    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

}
