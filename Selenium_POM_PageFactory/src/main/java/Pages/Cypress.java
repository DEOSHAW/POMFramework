package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Cypress {
	
	WebDriver driver;
	ExtentTest test;
	
	
	public Cypress(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[contains(text(),'Pricing')])[2]")
	WebElement pricingLink;
	@FindBy(xpath="//h2[@class='styled__Title-sc-bksqcq-4 bynjnO']")
	List<WebElement> licenseTypes;
	@FindBy(xpath="//span[@class='period']/preceding-sibling::span[@class='value']")
	List<WebElement> pricings;
	
	void getPricing() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		pricingLink.click();
		test.log(LogStatus.PASS, "Clicked on pricing link");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=0;i<licenseTypes.size();i++)
		{
			
			js.executeScript("arguments[0].scrollIntoView();", pricings.get(i));
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", pricings.get(i));
			Thread.sleep(1500);
			System.out.println(licenseTypes.get(i).getText()+"=====>"+"Rs. "+pricings.get(i).getText()+"/month");
		}
		test.log(LogStatus.PASS, "Pricing Displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
		
	}

}
