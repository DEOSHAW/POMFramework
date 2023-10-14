package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GumTree 
{
	WebDriver driver;
	ExtentTest test;
	
	public GumTree(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Services')]")
	WebElement servicesLink;
	
	@FindBy(xpath="//a[contains(@href,'/business-services/')]")
	List<WebElement> servicesList;
	
	void getListOfServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(servicesLink).perform();
		test.log(LogStatus.PASS, "Hovered over Services menu");
		Iterator<WebElement> itr=servicesList.iterator();
		StringBuilder serviceList=new StringBuilder();
		while(itr.hasNext())
		{
			serviceList.append(itr.next().getText());
			serviceList.append("\n");
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", serviceList.toString());
		Thread.sleep(3000);
		System.out.println(serviceList);
		test.log(LogStatus.PASS, "List of Services displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
