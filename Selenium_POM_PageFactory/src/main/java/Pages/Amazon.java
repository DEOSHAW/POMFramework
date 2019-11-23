package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Amazon {
	
	public WebDriver Amazon_Driver;
	
	public Amazon(WebDriver driver)
	{
		Amazon_Driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[text()='Account & Lists'])[1]")
	WebElement Account_Lists;
	
	@FindBy(xpath="(//span[text()='Sign in'][@class='nav-action-inner'])[1]")
	WebElement SignIn;
	@FindBy(name="email")
	WebElement Username;
	@FindBy(xpath="//span[@id='continue']")
	WebElement Continue;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(id="auth-signin-button")
	WebElement SignInSubmitButton;
	@FindBy(xpath="//*[@id='nav-your-amazon-text']")
	WebElement User;
	
	
	public void LogIntoAmazon() throws InterruptedException 
	{
		Actions action=new Actions(Amazon_Driver);
		action.moveToElement(Account_Lists).click(SignIn).build().perform();
		Thread.sleep(5000);
		Username.sendKeys("deoshaw3@gmail.com");
		Thread.sleep(3000);
		Continue.click();
		Amazon_Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Password.sendKeys("Dd$03091991");
		Thread.sleep(3000);
		SignInSubmitButton.click();
		Thread.sleep(15000);
		System.out.println("TagName is "+User.getTagName());
		System.out.println("Text is "+User.getText());
		Assert.assertTrue(User.getText().contains("DEO"));
		
		
		
		
		
		
		
	}

}
