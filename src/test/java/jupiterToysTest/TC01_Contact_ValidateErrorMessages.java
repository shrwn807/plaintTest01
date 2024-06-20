package jupiterToysTest;

import org.testng.annotations.Test;

import pages.contactPage;
import pages.navigation;
import utilities.Assertions;
import utilities.BaseTest;
import utilities.Controls;
import utilities.Data;

public class TC01_Contact_ValidateErrorMessages extends BaseTest {

	@Test(description = "Contact Page - Validate Error Messages on mandatory Fields")
	public void validateContactPageErrorMessages() {
		navigation nav = new navigation(driver);
		contactPage contact = new contactPage(driver);
		
		nav.navigateToMenu("Contact");
		
		Controls.click(contact.btn_Submit);
		Assertions.assertIsDisplayed(contact.label_ForenameErrorMsg, true);
		Assertions.assertIsDisplayed(contact.label_EmailErrorMsg, true);
		Assertions.assertIsDisplayed(contact.label_MessageErrorMsg, true);
		
		Controls.sendKeys(contact.input_Forename, Data.firstName());
		Controls.sendKeys(contact.input_Email, Data.emailAddress());
		Controls.sendKeys(contact.input_Message, Data.randomAlphanumeric("Automation Test ", 6));
		
		Assertions.assertIsDisplayed(contact.label_ForenameErrorMsg, false);
		Assertions.assertIsDisplayed(contact.label_EmailErrorMsg, false);
		Assertions.assertIsDisplayed(contact.label_MessageErrorMsg, false);
	}
	
}
