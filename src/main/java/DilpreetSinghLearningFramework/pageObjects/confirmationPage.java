package DilpreetSinghLearningFramework.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DilpreetSinghLearningFramework.AbstractComponents.abstractComponents;

public class confirmationPage extends abstractComponents {
	
	WebDriver driver;
	
	public confirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirm;
	
	public String getConfirmationMessage()
	{
		return confirm.getText();
	}

}
