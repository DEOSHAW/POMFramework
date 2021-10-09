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

public class SVG {
	
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	public SVG(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="(//*[name()='g'])[2]/*[local-name()='circle' and contains(@fill,'#990000')]")
	List<WebElement> SVGRedCirclesElement;
	
	public void findRedCircles() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		int noOfRedCircles=SVGRedCirclesElement.size();
		Iterator<WebElement> itr=SVGRedCirclesElement.iterator();
		while(itr.hasNext())
		{
			WebElement Circle=itr.next();
			if(Circle.isDisplayed())
			{
				test.log(LogStatus.PASS, "Circle is visible");
				Circle.click();
				test.log(LogStatus.PASS, "Clicked on circle");
				
			}
		}
		
		js.executeScript("alert(arguments[0])", "There are "+noOfRedCircles+" circles");
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		
	}
	

}
