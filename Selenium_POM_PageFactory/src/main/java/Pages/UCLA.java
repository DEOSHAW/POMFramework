package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UCLA {
	WebDriver driver;
	ExtentTest test;
	
	public UCLA(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@href,'/academics') and text()='Academics']")
	WebElement academicsLink;
	
	@FindBy(xpath="//a[contains(@href,'/academics') and text()='Academics']/following::ul//ul/li")
	List<WebElement> academics;
	
	
	void getAcademicDetails() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions actions=new Actions(driver);
		actions.moveToElement(academicsLink).build().perform();
		
		for(WebElement ele:academics)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", ele);
			Thread.sleep(200);
		}
		
		test.log(LogStatus.PASS, "All links highlighted");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
