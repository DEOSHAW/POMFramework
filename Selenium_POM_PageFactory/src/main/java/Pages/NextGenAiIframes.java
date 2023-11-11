package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NextGenAiIframes 
{
	WebDriver driver;
	ExtentTest test;
	
	public NextGenAiIframes(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//label[normalize-space(text())='First Name']/following-sibling::input")
	WebElement firstNameInputTextBox;
	
	@FindBy(xpath="//label[normalize-space(text())='Last Name']/following-sibling::input")
	WebElement lastNameInputTextBox;
	@FindBy(xpath="//button[text()='Alert Box']")
	WebElement alertButton;
	@FindBy(xpath="//h2/center")
	WebElement mainPageText;
	
	String switchBetweenIframes() throws InterruptedException
	{
		//Fill up form
		driver.switchTo().frame("formpage");
		firstNameInputTextBox.sendKeys("iFrame");
		lastNameInputTextBox.sendKeys("Test");
		//Handle alerts
		driver.switchTo().defaultContent();
		driver.switchTo().frame("popuppage");
		Thread.sleep(1500);
		alertButton.click();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		//Get Main page text
		driver.switchTo().defaultContent();
		return mainPageText.getText();
		
		
	}

}
