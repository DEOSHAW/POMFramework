package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class UITP_ShadowDom  
{
	
	WebDriver driver;
	ExtentTest test;
	
	public UITP_ShadowDom(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	//document.querySelector("body > section > div > guid-generator").shadowRoot.querySelector('#buttonGenerate')
	
	
	void generateGUID() throws Exception
	{
		
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement guidGeneratorButton=(WebElement) js.executeScript("return document.querySelector('body > section > div > guid-generator').shadowRoot.querySelector('#buttonGenerate')");
		guidGeneratorButton.click();
		test.log(LogStatus.PASS, "Clicked on GUID generator button");
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}
	
	
	

}
