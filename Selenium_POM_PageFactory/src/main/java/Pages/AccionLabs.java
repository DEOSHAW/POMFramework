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

public class AccionLabs {
	
	WebDriver driver;
	ExtentTest test;
	
	
	public AccionLabs(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[contains(text(),'Technology Levers of Innovation')]")
	WebElement techLeverText;
	
	@FindBy(xpath="//*[contains(@class,'authorFont imgListIconList')]")
	List<WebElement> techList;
	
	void getTechLeversOfInnovations() throws Exception
	{
		
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", techLeverText);
		test.log(LogStatus.PASS, "Navigated to tech lever section");
		StringBuilder techLevers=new StringBuilder();
		Iterator<WebElement> itr=techList.iterator();
		
		while(itr.hasNext())
		{
			techLevers.append(itr.next().getText());
			techLevers.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", techLevers.toString());
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "List of tech levers displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}
	
	

}
