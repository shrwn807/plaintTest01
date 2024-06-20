package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Controls;

public class navigation extends Controls {

WebDriver driver;
	
	public navigation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@id='nav-cart']/a")
	public WebElement link_Cart;
	
	public WebElement link_NavMenu(String label) { 
		return findElement("//ul[@class='nav']//a[contains(text(),'" + label + "')]"); 
	}
	
	public void navigateToMenu(String menuName) {
		click(link_NavMenu(menuName));
		waitForAngularRequest();
	}
	
	public void openCart() {
		click(link_Cart);
		waitForAngularRequest();
	}

}
