package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Guru99Alert {
	WebDriver driver_alert;
	ExtentTest test;
	public Guru99Alert(WebDriver driver,ExtentTest test)
	{
		driver_alert=driver;
		PageFactory.initElements(driver_alert, this);
		this.test=test;
	}
	@FindBy(xpath="//*[contains(text(),'Customer ID')]/following::input[1]")
	WebElement Customer_ID;
	@FindBy(xpath="//*[@name='submit']")
	WebElement Submit;
	
	public void AlertFunctionTest() throws Exception
	{
		
		Customer_ID.sendKeys("4556546");
		Submit.click();
		test.log(LogStatus.PASS, "Typed Value");
		Alert alert=driver_alert.switchTo().alert();
		Thread.sleep(2000);
		String text=alert.getText();
		System.out.println("Text on the alert is: "+text);
		alert.accept();
		Thread.sleep(2000);
		System.out.println("Text in Second alert is: "+alert.getText());
		alert.accept();
		test.log(LogStatus.PASS, "Pop up Handled");
		
		
		
	}

}
