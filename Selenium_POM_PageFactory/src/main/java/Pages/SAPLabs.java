package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SAPLabs {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	public SAPLabs(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//*[text()='Asia Pacific']")
	WebElement asiaPacificLabel;
	
	public void getAsiaPacificLocations() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		StringBuilder Locations=new StringBuilder();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", asiaPacificLabel);
		wait.until(ExpectedConditions.visibilityOf(asiaPacificLabel));
		test.log(LogStatus.PASS, "Asia pacific label visible");
		
		for(int i=1;i<=4;i++)
		{
			if(i==3)
			{
				String text=driver.findElement(By.xpath("//*[text()='Asia Pacific']/following::p[3]")).getText();
				Locations.append(text);
				Locations.append("\n");
				continue;
			}
			
			String text=driver.findElement(By.xpath("//*[text()='Asia Pacific']/following::p["+i+"]//a")).getText();
			Locations.append(text);
			Locations.append("\n");
		}
		
		js.executeScript("alert(arguments[0])",Locations.toString());
		test.log(LogStatus.PASS, "List of locations in asia pacific displayed");
		Thread.sleep(2800);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Test ended");
		
		
	}

}
