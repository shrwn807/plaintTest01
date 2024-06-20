package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Controls;

public class contactPage extends Controls {

WebDriver driver;
	
	public contactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='forename']")
	public WebElement input_Forename;
	@FindBy(xpath= "//input[@id='surname']")
	public WebElement input_Surname;
	@FindBy(xpath= "//input[@id='email']")
	public WebElement input_Email;
	@FindBy(xpath= "//input[@id='telephone']")
	public WebElement input_Telephone;
	@FindBy(xpath= "//textarea[@id='message']")
	public WebElement input_Message;
	@FindBy(xpath= "//a[contains(text(),'Submit')]")
	public WebElement btn_Submit;
	@FindBy(xpath= "//div[@class='alert alert-success']")
	public WebElement label_SuccessMsg;
	@FindBy(xpath= "//input[@id='forename']/following-sibling::span")
	public WebElement label_ForenameErrorMsg;
	@FindBy(xpath= "//input[@id='email']/following-sibling::span[@id='email-err']")
	public WebElement label_EmailErrorMsg;
	@FindBy(xpath= "//textarea[@id='message']/following-sibling::span")
	public WebElement label_MessageErrorMsg;
	
	@FindBy(xpath= "//div[contains(@class,'popup modal')]")
	public WebElement popup_SendingFeedback;
	@FindBy(xpath= "//div[contains(@class,'alert-success')]")
	public WebElement alert_SuccessFeedback;
	


}
