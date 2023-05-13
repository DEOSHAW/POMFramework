package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WTW 
{
	WebDriver driver;
	ExtentTest test;
	
	public WTW(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//span[@data-eventaction='Main Menu Opened']")
	WebElement hamMenu;
	@FindBy(how=How.XPATH,using="//span[@data-eventlabel='Click Text: About Us']")
	WebElement aboutUs;
	@FindBy(how=How.XPATH,using="//a[contains(@data-eventlabel,'Click Text: Overview')]")
	WebElement overview;
	@FindBy(how=How.XPATH,using="//p[contains(string(),'We are now WTW')]")
	WebElement overviewText;
	
	void aboutInfo() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		hamMenu.click();
		test.log(LogStatus.PASS, "Clicked on Menu");
		aboutUs.click();
		test.log(LogStatus.PASS, "Clicked on about us link");
		overview.click();
		test.log(LogStatus.PASS, "Clicked on Overview");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", overviewText);
		Thread.sleep(500);
		js.executeScript("alert(arguments[0])", overviewText.getText());
		test.log(LogStatus.PASS, "Overview text displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
