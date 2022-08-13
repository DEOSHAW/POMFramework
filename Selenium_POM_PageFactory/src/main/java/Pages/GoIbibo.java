package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class GoIbibo {
	WebDriver driver;
	ExtentTest test;
	
	public GoIbibo(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[text()='From']/parent::div")
	WebElement fromElement;
	@FindBy(xpath="//*[text()='To']/parent::div")
	WebElement toElement;
	@FindBy(xpath="//*[@type='text']")
	WebElement comboTextBoxsrc;
	@FindBy(xpath="//span[text()='To']/following-sibling::input")
	WebElement comboTextBoxdest;
	@FindBy(xpath="//span[text()='SEARCH FLIGHTS']")
	WebElement searchFlight;
	@FindBy(xpath="//div[contains(text(),'Now you get full refund on your domestic flight bookings')]")
	WebElement textElement;
	@FindBy(xpath="//*[text()='Domestic and International Flights']")
	WebElement textElement1;
	
	void searchFlights(String src,String dest) throws Exception
	{
		Robot robot=new Robot();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		test.log(LogStatus.PASS, "Test started");
		fromElement.click();
		js.executeScript("arguments[0].value=arguments[1]", comboTextBoxsrc,src);
		comboTextBoxsrc.click();
		//comboTextBoxsrc.sendKeys(src);
		//robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyRelease(KeyEvent.VK_ENTER);
		js.executeScript("arguments[0].click();", toElement);
		js.executeScript("arguments[0].value=arguments[1]", comboTextBoxdest,dest);
		comboTextBoxdest.click();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		test.log(LogStatus.PASS, "Typed source and destination");
		
		
	}

}
