package jupiterToysTest;

import org.testng.annotations.Test;

import pages.cartPage;
import pages.navigation;
import pages.shopPage;
import utilities.Assertions;
import utilities.BaseTest;

public class TC03_Shop_ValidateProductOnCart extends BaseTest {

	@Test(description = "Shop - Validate Adding of Products to Cart")
	public void validateAddingProductToCart() {
		navigation nav = new navigation(driver);
		shopPage shop = new shopPage(driver);
		cartPage cart = new cartPage(driver);
		
		nav.navigateToMenu("Shop");
		double StuffedFrogPrice = shop.getProductPrice("Stuffed Frog");
		double FluffyBunnyPrice = shop.getProductPrice("Fluffy Bunny");
		double ValentineBearPrice = shop.getProductPrice("Valentine Bear");
		
		shop.buyProduct("Stuffed Frog", 2);
		shop.buyProduct("Fluffy Bunny", 5);
		shop.buyProduct("Valentine Bear", 3);
		
		nav.openCart();
		double StuffedFrogSubtotal = cart.getItemSubtotal("Stuffed Frog");
		double FluffyBunnySubtotal = cart.getItemSubtotal("Fluffy Bunny");
		double ValentineBearSubtotal = cart.getItemSubtotal("Valentine Bear");
		
		/* Validate Subtotal for each item */
		Assertions.assertEquals(StuffedFrogSubtotal, StuffedFrogPrice * 2);
		Assertions.assertEquals(FluffyBunnySubtotal, FluffyBunnyPrice * 5);
		Assertions.assertEquals(ValentineBearSubtotal, ValentineBearPrice * 3);
		
		/* Validate Price for each item */
		Assertions.assertEquals(cart.getItemPrice("Stuffed Frog"), StuffedFrogPrice);
		Assertions.assertEquals(cart.getItemPrice("Fluffy Bunny"), FluffyBunnyPrice);
		Assertions.assertEquals(cart.getItemPrice("Valentine Bear"), ValentineBearPrice);
		
		/* Validate Total Amount */
		Assertions.assertEquals(cart.getTotalAmount(), StuffedFrogSubtotal + FluffyBunnySubtotal + ValentineBearSubtotal);
	}
	
}
