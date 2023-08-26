package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		wait=new WebDriverWait(twitterDriver,Duration.ofSeconds(10));
	}
	//@FindBy(xpath="//*[text()='Sign up with phone or email']")
	//WebElement createYourAccount;
	@FindBy(xpath="//*[text()='Sign up with phone or email']")
	WebElement signUpLink;
	@FindBy(xpath="//*[@name='name']")
	WebElement nameTextBox;
	@FindBy(xpath="//*[@name='phone_number']")
	WebElement phoneNumberTextBox;
	@FindBy(xpath="(//select[contains(@id,'SELECTOR_')])[1]")
	WebElement monthDropDown;
	@FindBy(xpath="(//select[contains(@id,'SELECTOR_')])[2]")
	WebElement dayDropDown;
	@FindBy(xpath="(//select[contains(@id,'SELECTOR_')])[3]")
	WebElement yearDropDown;
	@FindBy(xpath="//*[text()='Next']")
	WebElement nextLink;
	
	public void signUpOnTwitter(String name,String Phone) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(signUpLink));
		signUpLink.click();
		test.log(LogStatus.PASS, "Clicked on SignUp Link");
		js.executeScript("arguments[0].value=arguments[1];", nameTextBox,name);
		js.executeScript("arguments[0].value=arguments[1];", phoneNumberTextBox,Phone);
		Select Month=new Select(monthDropDown);
		Select Day=new Select(dayDropDown);
		Select Year=new Select(yearDropDown);
		Month.selectByIndex(9);
		Day.selectByIndex(3);
		Year.selectByValue("1991");
		test.log(LogStatus.PASS, "Entered all details");
		//nextLink.click();
		test.log(LogStatus.PASS, "Clicked On Next Button");
		Thread.sleep(4000);
		
		
		
	}

}
