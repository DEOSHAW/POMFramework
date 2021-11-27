package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AADHAR {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	public AADHAR(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//*[contains(normalize-space(text()),'अन्तर्राष्ट्रीय योग दिवस 2020 के अवसर पर प्रधानमंत्री नरेंद्र मोदी की देशवासियों से अपील')])[1]")
	WebElement yogaDay;
	
	void getAADHARTelecast() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", yogaDay);
		test.log(LogStatus.PASS, "Scrolled downwards");
		Thread.sleep(500);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(500);
		js.executeScript("alert(arguments[0])", yogaDay.getText());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Information displayed");
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
