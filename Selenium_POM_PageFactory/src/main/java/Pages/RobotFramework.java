package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RobotFramework {
	WebDriver roboDriver;
	ExtentTest test;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public RobotFramework(WebDriver driver,ExtentTest test)
	   {
		  roboDriver=driver;
		   PageFactory.initElements(driver, this);
		   this.test=test;
		   
	   }
	
	@FindBy(how=How.XPATH,using="//*[normalize-space(text())='MODULAR']")
	WebElement modularElement;
	
	public void getDetails()
	{
		wait=new WebDriverWait(roboDriver,10);
		js=(JavascriptExecutor)roboDriver;
		js.executeScript("arguments[0].scrollIntoView(true);", modularElement);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, "Scrolled to modularElement");
		String modText=modularElement.getText();
		Assert.assertEquals(modText, "MODULAR","Validation successful");
		test.log(LogStatus.PASS, "MODULAR text found");
	}
	

}
