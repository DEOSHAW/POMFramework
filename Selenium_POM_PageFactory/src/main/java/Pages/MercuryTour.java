package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MercuryTour 
{
	WebDriver driver;
	ExtentTest test;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement userNameInputBox;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordInputBox;
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitButton;
	@FindBy(how=How.TAG_NAME,using="h3")
	WebElement successMessage;
	
	
	public MercuryTour(WebDriver driver)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	

	
	String login(String userName,String password)
	{
		userNameInputBox.sendKeys(userName);
		passwordInputBox.sendKeys(password);
		submitButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		return successMessage.getText();
		
		
	}

}
