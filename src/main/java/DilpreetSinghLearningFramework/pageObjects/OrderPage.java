package DilpreetSinghLearningFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DilpreetSinghLearningFramework.AbstractComponents.abstractComponents;

public class OrderPage extends abstractComponents{
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;

	
	public boolean verifyOrderDisplay(String productName)
	{
		boolean match = productNames.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));
		return match;
	}
}
