package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ABS {
	WebDriver driver;
	ExtentTest test;
	
	public ABS(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='programs.asp' and @class='main-menu']")
	WebElement programsLink;
	@FindBy(css="a.accordion-toggle.collapsed")
	List<WebElement> allPrograms;
	
	private void getPrograms() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", programsLink);
		test.log(LogStatus.PASS, "Navigated to Programs page");
		StringBuilder allBusinessPrograms=new StringBuilder();
		System.out.println("Total Programs: "+allPrograms.size());
		Iterator<WebElement> itr=allPrograms.iterator();
		while(itr.hasNext())
		{
			allBusinessPrograms.append(itr.next().getText());
			allBusinessPrograms.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", allBusinessPrograms.toString());
		test.log(LogStatus.PASS, "List of Business Programs displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
