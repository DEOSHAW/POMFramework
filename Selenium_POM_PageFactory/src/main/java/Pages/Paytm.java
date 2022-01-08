package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class Paytm {
	WebDriver driver;
	ExtentTest test;
	
	
	public Paytm(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Paytm For Business')]")
	WebElement paytmForBusinessMenuItem;
	
	@FindBy(xpath="//a[text()='Financial Service']/parent::div")
	WebElement financialServicesMenuItem;
	
	@FindBy(xpath="//a[text()='Financial Service']/parent::div/following-sibling::ul/li/div/a")
	List<WebElement> financialServices;
	
	
	void getListOfFinServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		paytmForBusinessMenuItem.click();
		Thread.sleep(1000);
		financialServicesMenuItem.click();
		test.log(LogStatus.PASS, "Clicked on financial services");
		Thread.sleep(2000);
		StringBuilder listOfFinServices=new StringBuilder();
		Iterator<WebElement> itr=financialServices.iterator();
		while(itr.hasNext())
		{
			listOfFinServices.append(itr.next().getText());
			listOfFinServices.append("\n");
			
		}
		seleniumUtilities.showAlert(driver, listOfFinServices.toString());
		test.log(LogStatus.PASS, "List of Financial services displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
