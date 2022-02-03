package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SAS_INC {
	WebDriver driver;
	ExtentTest test;
	
	
	public SAS_INC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h3[contains(text(),'Banking')]/parent::div")
	WebElement bankingLink;
	@FindBy(xpath="(//*[@class='parsys_column cq-colctrl-lt3'])[6]/child::div/child::div/div/child::div[@class='par parsys']/child::div[3]/child::div/h3")
	List<WebElement> bankingSolutions;
	
	void getSASBankingSolutions() throws Exception
	{
		int count=1;
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",bankingLink);
		js.executeScript("arguments[0].click();",bankingLink);
		//bankingLink.click();
		js.executeScript("arguments[0].scrollIntoView();",bankingSolutions.get(0));
		Thread.sleep(2500);
		js.executeScript("window.scrollBy(0,-200);");
		for(WebElement solution:bankingSolutions)
		{
			
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Blue')", solution);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Highlighted Element-"+count);
			count++;
		}
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
