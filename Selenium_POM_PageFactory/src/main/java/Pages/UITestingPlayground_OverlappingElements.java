package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UITestingPlayground_OverlappingElements {
	WebDriver driver;
	ExtentTest test;
	
	public UITestingPlayground_OverlappingElements(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@placeholder='Name']")
	WebElement nameTextBox;
	
	void enterTextInOverlappedTextBox(String text) throws Exception
	{
		System.out.println(text);
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", nameTextBox);
		nameTextBox.sendKeys(text);
		test.log(LogStatus.PASS, "Text entered in overlapped Element");
		test.log(LogStatus.PASS, "Test Ended");
		Thread.sleep(4000);
		
		
	}
	

}
