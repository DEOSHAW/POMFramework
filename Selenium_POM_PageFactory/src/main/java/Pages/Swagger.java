package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Swagger {
	WebDriver driver;
	ExtentTest test;
	
	public Swagger(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Tools') and @data-toggle='dropdown']")
	WebElement toolsDropdown;
	
	@FindBy(xpath="//div[@id='proDocumentation']/child::a/span")
	List<WebElement> proTools;
	
	
	void getProTools()
	{
		
		test.log(LogStatus.PASS, "Test Started");
		toolsDropdown.click();
		System.out.println("Pro Tools: ");
		for(WebElement tool: proTools)
		{
			System.out.println(tool.getText());
		}
		
		System.out.println("******************");
		
		test.log(LogStatus.PASS, "List of Pro tools displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
