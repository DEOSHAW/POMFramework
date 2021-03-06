package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Twitter {
	
	WebDriver twitterDriver;
	ExtentTest test;
	JavascriptExecutor js=null;
	WebDriverWait wait;
	
	public Twitter(WebDriver driver,ExtentTest test)
	{
		twitterDriver=driver;
		this.test=test;
		PageFactory.initElements(twitterDriver, this);
		js=(JavascriptExecutor)twitterDriver;
		wait=new WebDriverWait(twitterDriver,10);
	}
	@FindBy(xpath="//*[text()='Create your account']")
	WebElement createYourAccount;
	@FindBy(xpath="//*[text()='Sign up']")
	WebElement signUpLink;
	@FindBy(xpath="//*[@name='name']")
	WebElement nameTextBox;
	@FindBy(xpath="//*[@name='phone_number']")
	WebElement phoneNumberTextBox;
	@FindBy(xpath="//select[@aria-label='Month']")
	WebElement monthDropDown;
	@FindBy(xpath="//select[@aria-label='Day']")
	WebElement dayDropDown;
	@FindBy(xpath="//select[@aria-label='Year']")
	WebElement yearDropDown;
	@FindBy(xpath="//*[text()='Next']")
	WebElement nextLink;
	
	public void signUpOnTwitter(String name,String Phone) throws InterruptedException
	{
		signUpLink.click();
		test.log(LogStatus.PASS, "Clicked on SignUp Link");
		wait.until(ExpectedConditions.visibilityOf(createYourAccount));
		String text=(String) js.executeScript("return arguments[0].innerHTML;", createYourAccount);
		Assert.assertEquals(text, "Create your account");
		js.executeScript("arguments[0].value=arguments[1];", nameTextBox,name);
		js.executeScript("arguments[0].value=arguments[1];", phoneNumberTextBox,Phone);
		Select Month=new Select(monthDropDown);
		Select Day=new Select(dayDropDown);
		Select Year=new Select(yearDropDown);
		Month.selectByIndex(9);
		Day.selectByIndex(3);
		Year.selectByValue("1991");
		test.log(LogStatus.PASS, "Entered all details");
		nextLink.click();
		test.log(LogStatus.PASS, "Clicked On Next Button");
		Thread.sleep(4000);
		
		
		
	}

}
