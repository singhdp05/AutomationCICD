package DilpreetSinghLearningFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DilpreetSinghLearningFramework.AbstractComponents.abstractComponents;

public class CartPage extends abstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProd;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	public boolean verifyProduct(String productName)
	{
		boolean match = CartProd.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkoutEle.click();
		CheckoutPage check = new CheckoutPage(driver);
		return check;
	}
	
	

}
