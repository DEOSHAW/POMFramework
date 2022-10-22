package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UITP_MouseHover {
	WebDriver driver;
	ExtentTest test;
	
	public UITP_MouseHover(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="clickCount")
	WebElement clickCount;
	@FindBy(xpath="//a[contains(text(),'Click me')]")
	WebElement clickMeLink;
	
	
	boolean validateMouseClickIncrementsCounter() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test started");
		int noOfClicks=5;
		int initialCount=Integer.parseInt(clickCount.getText());
		for(int i=0;i<noOfClicks;i++)
		{
			clickMeLink.click();
			Thread.sleep(500);
		}
		
		test.log(LogStatus.PASS, "Clicked "+noOfClicks+" times");
		
		int updatedCount=Integer.parseInt(clickCount.getText());
		
		if(updatedCount-initialCount==noOfClicks)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}

}
