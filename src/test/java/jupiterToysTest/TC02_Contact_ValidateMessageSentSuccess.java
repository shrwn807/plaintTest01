package jupiterToysTest;

import org.testng.annotations.Test;

import pages.contactPage;
import pages.navigation;
import utilities.Assertions;
import utilities.BaseTest;
import utilities.Controls;
import utilities.Data;

public class TC02_Contact_ValidateMessageSentSuccess extends BaseTest {

	@Test(description = "Contact Page - Validate Success Message")
	public void validateContactSuccessfulMessage() {
		navigation nav = new navigation(driver);
		contactPage contact = new contactPage(driver);
		int numberOfLoop = 5;
		
		nav.navigateToMenu("Contact");
		
		for(int i = 1; i <= numberOfLoop; i++) {
			String firstName = Data.firstName();
			Controls.sendKeys(contact.input_Forename, firstName);
			Controls.sendKeys(contact.input_Email, Data.emailAddress());
			Controls.sendKeys(contact.input_Message, Data.randomAlphanumeric("Automation Test ", 6));
			Controls.click(contact.btn_Submit);
			Controls.waitForInvisibilityOfElement(contact.popup_SendingFeedback);
			
			Assertions.assertText(contact.alert_SuccessFeedback, "Thanks " + firstName + ", we appreciate your feedback.");
			Controls.refreshPage();
			System.out.println("Sent feedback no.: " + i);
		}
		
	}
	
}
