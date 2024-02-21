package DilpreetSinghLearningFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DilpreetSinghLearningFramework.pageObjects.CartPage;
import DilpreetSinghLearningFramework.pageObjects.OrderPage;

public class abstractComponents {
	
	WebDriver driver;
	
	
	public abstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement orderHeader;

	public void waitForElementToAppear(By find) 	//by locator
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	}
	
	public void waitForWebElementToAppear(WebElement find) 	//by locator
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(find));
	}
	
	public void waitForElementToDisAppear(WebElement ele) throws InterruptedException 	//by locator
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCart()
	{	cartHeader.click();
		CartPage cart = new CartPage(driver);
		return cart;
		
	}
	
	public OrderPage goToOrders()
	{	orderHeader.click();
		OrderPage order = new OrderPage(driver);
		return order;
		
	}
	
	
	

}
