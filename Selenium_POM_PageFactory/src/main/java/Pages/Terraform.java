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

public class Terraform {
	
	WebDriver driver;
	ExtentTest test;
	
	public Terraform(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[text()='Use Cases']")
	WebElement useCases;
	
	@FindBy(xpath="//*[text()='Use Cases']/following::li/a[contains(@href,'use-cases')]")
	List<WebElement> allUseCases;
	
	void getUseCases() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		useCases.click();
		test.log(LogStatus.PASS, "Opened list of use cases");
		Iterator<WebElement> itr=allUseCases.iterator();
		StringBuilder useCases=new StringBuilder();
		while(itr.hasNext())
		{
			useCases.append(itr.next().getText());
			useCases.append("\n");
			
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", useCases.toString());
		test.log(LogStatus.PASS, "Displayed all the use cases");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
