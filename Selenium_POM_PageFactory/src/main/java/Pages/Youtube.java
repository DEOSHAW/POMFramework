package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Youtube {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public Youtube(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.ID,using="logo-icon")
	WebElement logoIcon;
	@FindBy(xpath="//*[@id='video-title']")
	List<WebElement> videoTitles;
	
	
	public void getVideoTitles() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(logoIcon));
		test.log(LogStatus.PASS, "Youtube launched");
		Iterator<WebElement> itr=videoTitles.iterator();
		StringBuilder builder=new StringBuilder();
		while(itr.hasNext())
		{
			builder.append(itr.next().getText());
			builder.append("\n");
		}
		js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", builder.toString());
		test.log(LogStatus.PASS, "List displayed");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Test Ended");
		
    }

}
