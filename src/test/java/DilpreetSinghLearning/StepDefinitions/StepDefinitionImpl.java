package DilpreetSinghLearning.StepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DilpreetSinghLearningFramework.TestComponents.baseTest;
import DilpreetSinghLearningFramework.pageObjects.CartPage;
import DilpreetSinghLearningFramework.pageObjects.CheckoutPage;
import DilpreetSinghLearningFramework.pageObjects.confirmationPage;
import DilpreetSinghLearningFramework.pageObjects.landingPage;
import DilpreetSinghLearningFramework.pageObjects.productCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends baseTest {
	
	public landingPage Landingpage;
	public productCatalogue prodCat;
	public confirmationPage con;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		Landingpage=launchApplication();
	}
	
	@Given("^Logged in with username(.+) and password(.+)$")
	//regular expression used for parameter values should start with '^' and ends with '$'
	public void Logged_in_username_and_password(String name, String password)
	{
		prodCat = landing.loginApp(name,password);
	}
	
	@When("^I add the product (.+) to cart$")
	public void I_add_the_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = prodCat.getProductList();
		prodCat.addProductToCart(productName);
	}
	 
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws InterruptedException
		{
			CartPage cart = prodCat.goToCart();
			boolean match = cart.verifyProduct(productName);
			Assert.assertTrue(match);
			CheckoutPage check = cart.goToCheckout();
			check.selectCountry("india");
			con = check.submitOrder();
		}
	
	@Then ("{string} message is displayed on ConfirmationPage")
	public void message_is_displayed_on_ConfirmationPage(String string)
	{
		String message = con.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string, landing.errorMessage());
		driver.close();
		
	}
}
