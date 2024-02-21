package DilpreetSinghLearningFramework.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DilpreetSinghLearningFramework.TestComponents.baseTest;
import DilpreetSinghLearningFramework.pageObjects.CartPage;
import DilpreetSinghLearningFramework.pageObjects.CheckoutPage;
import DilpreetSinghLearningFramework.pageObjects.OrderPage;
import DilpreetSinghLearningFramework.pageObjects.confirmationPage;
import DilpreetSinghLearningFramework.pageObjects.landingPage;
import DilpreetSinghLearningFramework.pageObjects.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends baseTest{

	String productName = "IPHONE 13 PRO";
	@Test(dataProvider="getData", groups= {"purchase"})
	
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		productCatalogue prodCat = landing.loginApp(input.get("email"), input.get("password"));
		List<WebElement> products = prodCat.getProductList();
		prodCat.addProductToCart(input.get("product"));
		prodCat.goToCart();
		CartPage cart = new CartPage(driver);
		boolean match = cart.verifyProduct(input.get("product"));
		Assert.assertTrue(match);
		cart.goToCheckout();
		CheckoutPage check = new CheckoutPage(driver);
		check.selectCountry("india");
		confirmationPage con = check.submitOrder();
		String message = con.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	//to verify IPHONE 13 PRO is displaying in orders page
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		productCatalogue prodCat = landing.loginApp("abc@learning.com", "Sahaj2003@");
		OrderPage order = prodCat.goToOrders();
		Assert.assertTrue(order.verifyOrderDisplay(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException        
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//DilpreetLearning//data//purchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData()   //Here object is generic data type which can accept any type like int, string etc
//	{
//		return new Object[][] {{"abc@learning.com", "Sahaj2003@", "IPHONE 13 PRO"},{"singh5@gmail.com", "Dpsingh05@", "ADIDAS ORIGINAL"}};
//	}
	
//	HashMap<String,String> map = new HashMap<String,String>();     //Integrating hashmap to data provider to send data as one hash object
//	map.put("email", "abc@learning.com");
//	map.put("password", "Sahaj2003@");
//	map.put("product", "IPHONE 13 PRO");
//	
//	HashMap<String,String> map1 = new HashMap<String,String>();
//	map1.put("email", "singh5@gmail.com");
//	map1.put("password", "Dpsingh05@");
//	map1.put("product", "ADIDAS ORIGINAL");
//	return new Object[][] {{map},{map1}};
}
