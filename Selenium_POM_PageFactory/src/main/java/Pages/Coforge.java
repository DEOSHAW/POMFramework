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

public class Coforge {
	
	WebDriver driver;
	ExtentTest test;
	
	public Coforge(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Our Services')]")
	WebElement servicesLabel;
	
	@FindBy(xpath="(//*[@class='row d-none d-md-flex'])[3]//h6")
	List<WebElement> servicesList;
	
	void displayListOfServices() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", servicesLabel);
		
		test.log(LogStatus.PASS, "Navigated to services section");
		
		StringBuilder listOfServices=new StringBuilder();
		
		Iterator<WebElement> itr=servicesList.iterator();
		
		while(itr.hasNext())
		{
			listOfServices.append(js.executeScript("return arguments[0].innerHTML;", itr.next()));
			listOfServices.append("\n");
			
		}
		
		js.executeScript("alert(arguments[0])", listOfServices.toString());
		
		test.log(LogStatus.PASS, "List of services displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
