package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class OrangeHRM {
	WebDriver driver;
	ExtentTest test;
	
	public OrangeHRM(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@placeholder='Email Address']")
	WebElement emailTextBox;
	
	@FindBy(xpath="//input[@type='submit' and @value='Try OrangeHRM for Free']")
	WebElement tryHRMFreeLink;
	
	@FindBy(xpath="//*[@name='subdomain']")
	WebElement urlElement;
	
	@FindBy(xpath="//*[@placeholder='Full Name']")
	WebElement fullName;
	@FindBy(xpath="//*[@placeholder='Phone Number']")
	WebElement phoneNumber;
	@FindBy(xpath="//*[@name='Country']")
	WebElement country;
	
	@FindBy(xpath="//*[@title='reCAPTCHA']")
	WebElement captchaIframe;
	
	@FindBy(xpath="//*[@role='presentation']")
	WebElement Captcha;
	
	
	
	void registerOnOrangeHRM() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.jsType(driver, emailTextBox, seleniumUtilities.getDataForKey("EMAIL"));
		tryHRMFreeLink.click();
		seleniumUtilities.highlightElement(driver, urlElement);
		urlElement.sendKeys("hrm.in");
		Thread.sleep(800);
		seleniumUtilities.highlightElement(driver, fullName);
		fullName.sendKeys("Deo Prasad Shaw");
		Thread.sleep(800);
		seleniumUtilities.highlightElement(driver, phoneNumber);
		phoneNumber.sendKeys("7845552245");
		Thread.sleep(800);
		seleniumUtilities.highlightElement(driver, country);
		Select countryDropDown=new Select(country);
		countryDropDown.selectByVisibleText("India");
		test.log(LogStatus.PASS, "Entered all details");
		Thread.sleep(800);
		seleniumUtilities.highlightElement(driver, captchaIframe);
		Thread.sleep(500);
		seleniumUtilities.highlightElement(driver, Captcha);
		driver.switchTo().frame(captchaIframe);
		Captcha.click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Test ended");
	}

}
