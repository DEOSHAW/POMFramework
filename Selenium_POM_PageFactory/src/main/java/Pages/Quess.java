package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Quess {
	WebDriver driver;
	ExtentTest test;
	
	public Quess(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	By businessVerticals=By.xpath("(//span[text()='Business Verticals'])[1]");
	@FindBy(xpath="(//a[text()='Global Technology Solutions'])[1]")
	WebElement GTSElement;
	@FindBy(xpath="(//a[text()='Domestic IT Services'])[1]")
	WebElement domesticITServicesElement;
	@FindBy(xpath="//p[contains(text(),'integrated services')]")
	WebElement domesticITServicesInfo;
	
	void getInformationOnDomesticITServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		String parentWindow=driver.getWindowHandle();
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(businessVerticals)).pause(Duration.ofSeconds(1))
		.moveToElement(GTSElement).pause(Duration.ofSeconds(2)).click(domesticITServicesElement).build().perform();
		Set<String> allWindows=driver.getWindowHandles();
		for(String currentWindow:allWindows)
		{
			if(!parentWindow.equalsIgnoreCase(currentWindow))
			{
				driver.switchTo().window(currentWindow);
				break;
			}
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", domesticITServicesInfo);
		
		String info=(String) js.executeScript("return arguments[0].innerHTML;", domesticITServicesInfo);
		System.out.println(info);
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Domestic IT Services information displayed");
		
		
		test.log(LogStatus.PASS, "Test Ended");
	}

}
