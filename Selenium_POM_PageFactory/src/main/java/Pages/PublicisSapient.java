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

public class PublicisSapient {
	WebDriver driver;
	ExtentTest test;
	
	public PublicisSapient(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='menu']")
	WebElement menuButton;
	@FindBy(xpath="//span[text()='Services ']")
	WebElement servicesButton;
	@FindBy(xpath="//span[text()='Services ']/parent::a/following::ul[1]/li//span")
	List<WebElement> allServices;
	
	
	void getListOfServices() throws InterruptedException
	{
		
		test.log(LogStatus.PASS, "Test Started");
		
		menuButton.click();
		
		servicesButton.click();
		
		StringBuilder listOfServices=new StringBuilder();
		
		Iterator<WebElement> itr=allServices.iterator();
		
		while(itr.hasNext())
		{
			listOfServices.append(itr.next().getText());
			listOfServices.append("\n");
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", listOfServices.toString());
		
		Thread.sleep(1500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		
		test.log(LogStatus.PASS, "List of Services displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
