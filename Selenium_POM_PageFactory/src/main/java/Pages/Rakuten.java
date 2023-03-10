package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Rakuten {
	WebDriver driver;
	ExtentTest test;
	
	public Rakuten(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[contains(text(),'About Us')])[1]")
	WebElement aboutUsLink;
	
	@FindBy(xpath="(//a[contains(text(),'Our Businesses')])[1]")
	WebElement ourBusinessesLink;
	
	@FindBy(xpath="//h2[text()='Company (Services)']/parent::section/child::div/child::div//span[2]")
	List<WebElement> businessList;
	
	
	private void getBusinesses() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutUsLink).pause(Duration.ofSeconds(1)).click(ourBusinessesLink).perform();
		test.log(LogStatus.PASS, "Navigated to Businesses section");
		StringBuilder allBusinesses=new StringBuilder();
		
		for(WebElement Business:businessList)
		{
			
			allBusinesses.append(Business.getText());
			allBusinesses.append("\n");
			
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", allBusinesses.toString());
		test.log(LogStatus.PASS, "List of Rakuten Businesses displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
