package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Natwest {
	WebDriver driver;
	ExtentTest test;
	
	public Natwest(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[normalize-space(text())='CareerSense']")
	WebElement careerSenseHeader;
	@FindBy(xpath="(//*[@class='rte-wrapper'])[3]//p")
	List<WebElement> careerSensePara;
	
	void getCareerSense() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", careerSenseHeader);
		test.log(LogStatus.PASS, "Scrolled to career sense section");
		Thread.sleep(2000);
		Iterator<WebElement> itr=careerSensePara.iterator();
		StringBuilder Text=new StringBuilder();
		while(itr.hasNext())
		{
			Text.append(itr.next().getText());
			Text.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", Text.toString());
		test.log(LogStatus.PASS, "Displayed career sense text");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
		
	}

}
