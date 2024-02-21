package DilpreetSinghLearningFramework.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import DilpreetSinghLearningFramework.TestComponents.baseTest;
import DilpreetSinghLearningFramework.pageObjects.CartPage;
import DilpreetSinghLearningFramework.pageObjects.CheckoutPage;
import DilpreetSinghLearningFramework.pageObjects.confirmationPage;

import DilpreetSinghLearningFramework.pageObjects.landingPage;
import DilpreetSinghLearningFramework.pageObjects.productCatalogue;

public class errorValidationTest extends baseTest{

	@Test(groups = {"errorhandling"},retryAnalyzer=DilpreetSinghLearningFramework.TestComponents.Rtry.class)
	
	public void LoginerrorValidation() throws IOException, InterruptedException
	{
	//	String productName = "IPHONE 13 PRO";
	//	landingPage landing = new landingPage(driver);
	//	landingPage landing = launchApplication();
		landing.loginApp("abc@learning.com", "Shaj2003@");
		Assert.assertEquals("Incorrect email or password.", landing.errorMessage());
	
		
	}
	
	@Test
	
	public void ProducterrorValidation() throws IOException, InterruptedException
	{
		String productName = "IPHONE 13 PRO";
	//	landingPage landing = new landingPage(driver);
	//	landingPage landing = launchApplication();
		landing.loginApp("abc@learning.com", "Sahaj2003@");
		productCatalogue prodCat = new productCatalogue(driver);
		List<WebElement> products = prodCat.getProductList();
		prodCat.addProductToCart(productName);
		prodCat.goToCart();
		CartPage cart = new CartPage(driver);
		boolean match = cart.verifyProduct("iphone");
		Assert.assertFalse(match);
	}
}


