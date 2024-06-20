package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.Controls;

public class shopPage extends Controls {

WebDriver driver;
	
	public shopPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement btn_BuyProduct(String itemName) { 
		return findElement("//h4[text()='" + itemName + "']/following-sibling::p/a"); 
	}
	public WebElement label_ProductPrice(String itemName) { 
		return findElement("//h4[text()='" + itemName + "']/following-sibling::p/span"); 
	}
	public void buyProduct(String itemName, int qty) {
		for (int i = 1; i <= qty; i++) {
			click(btn_BuyProduct(itemName));
		}
	}
	public Double getProductPrice(String itemName) {
		return convertStringToDouble(label_ProductPrice(itemName));
	}

}
