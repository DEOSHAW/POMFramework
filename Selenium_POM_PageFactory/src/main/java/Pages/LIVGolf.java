package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LIVGolf {
	WebDriver driver;
	ExtentTest test;
	
	
	public LIVGolf(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='About']")
	WebElement aboutLink;
	@FindBy(xpath="//p[contains(text(),'Our mission is to modernize')]")
	WebElement aboutText;
	
	
	void getMotto() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		aboutLink.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("alert(arguments[0])", aboutText.getText());
		test.log(LogStatus.PASS, "Motto Displayed");
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
