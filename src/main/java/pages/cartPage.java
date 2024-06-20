package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Controls;

public class cartPage extends Controls {

WebDriver driver;
	
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tfoot//strong")
	public WebElement label_totalPrice;
	
	public WebElement label_itemPrice(String itemName) { 
		return findElement("//td[contains(text(),'" + itemName + "')]/following-sibling::td[1]"); 
	}
	
	public WebElement label_Subtotal(String itemName) { 
		return findElement("//td[contains(text(),'" + itemName + "')]/following-sibling::td[3]"); 
	}
	
	public Double getItemPrice(String itemName) {
		return convertStringToDouble(label_itemPrice(itemName));
	}
	
	public Double getItemSubtotal(String itemName) {
		return convertStringToDouble(label_Subtotal(itemName));
	}
	
	public Double getTotalAmount() {
		return convertStringToDouble(label_totalPrice);
	}

}
