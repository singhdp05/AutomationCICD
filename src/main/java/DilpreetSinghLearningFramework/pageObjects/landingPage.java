package DilpreetSinghLearningFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DilpreetSinghLearningFramework.AbstractComponents.abstractComponents;

public class landingPage extends abstractComponents{
	WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPwd;
	
	@FindBy(id="login")
	WebElement Submit;
	
//	.ng-tns-c4-4.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public productCatalogue loginApp(String mail,String pwd)
	{
//		productCatalogue prodcat = new productCatalogue(driver);
		userEmail.sendKeys(mail);
		userPwd.sendKeys(pwd);
		Submit.click();
		return new productCatalogue(driver);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String errorMessage() 
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	

}
