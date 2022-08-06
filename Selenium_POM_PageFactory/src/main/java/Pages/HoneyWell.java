package Pages;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HoneyWell {
	WebDriver driver;
	ExtentTest test;
	
	public HoneyWell(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[starts-with(text(),'Industries')]")
	WebElement IndustriesLink;
	@FindBy(xpath="//span[contains(text(),'What We Do')]")
	WebElement whatWeDoLink;
	@FindBy(xpath="//*[@class='grid-head']")
	List<WebElement> ISUs;
	
	
	void getBusinessLines() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		IndustriesLink.click();
		whatWeDoLink.click();
		test.log(LogStatus.PASS, "Navigated to ISUs page");
		JavascriptExecutor js=(JavascriptExecutor)driver;
			
		for(int i=0;i<ISUs.size();i++)
		{
			if(i==0)
			{
				js.executeScript("window.scrollBy(0,800)");
				
			}
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", ISUs.get(i));
			Thread.sleep(500);
			
		}
		test.log(LogStatus.PASS, "All ISUs highlighted");
		
		test.log(LogStatus.PASS, "Test Ended");
	}

}
