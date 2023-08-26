package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VaishnoDevi {
	WebDriver driver=null;
	ExtentTest test;
	JavascriptExecutor js=null;
	WebDriverWait wait=null;
	Actions actions=null;
	
	
	public VaishnoDevi(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using="//*[starts-with(text(),'Shri Mata Vaishno Devi Shrine Board')]")
	WebElement pageText;
	@FindBy(xpath="//*[contains(text(),'Plan a Yatra')]")
	WebElement planYatra;
	@FindBy(xpath="//*[contains(text(),'How to Reach')]")
	WebElement howToReach;
	@FindBy(xpath="//*[contains(text(),'Katra to Bhawan')]")
	WebElement katraToBhawan;
	@FindBy(xpath="//*[text()='Darshani Darwaaza']")
	WebElement darshaniDarwaaza;
	
	
	public void getDetails()
	{
		js=(JavascriptExecutor)driver;
		String text=(String) js.executeScript("return arguments[0].innerHTML;", pageText);
		System.out.println("Text is: "+text);
		test.log(LogStatus.PASS, "Expected text found");
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(planYatra));
		actions=new Actions(driver);
		actions.moveToElement(planYatra).moveToElement(howToReach).click(katraToBhawan).build().perform();
		String darshaniText=wait.until(ExpectedConditions.visibilityOf(darshaniDarwaaza)).getText();
		Assert.assertEquals(darshaniText, "Darshani Darwaaza");
		test.log(LogStatus.PASS, "Expected text Darshani Darwaaza found");
		
		
	}

}
