package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationTesting {
	
	WebDriver driver;
	ExtentTest test;
	
	public AutomationTesting(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
	}
	
	
	
	
	public void EditDetails()
	{
		
		Actions action=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String newText="Deo";
		
		int count=0;
		for(int i=1;i<=50;i++)
		{
			
			
		
		WebElement ele=driver.findElement(By.xpath("(//*[@role='grid']//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope')])["+i+"]"));
		String Text=ele.getText();
		if(Text.contains("castro"))
		{
			test.log(LogStatus.PASS, "Found expected text"); 
			WebElement editButton=driver.findElement(By.xpath("(//*[@role='grid']//div[contains(@class,'ui-grid-cell-contents ng-binding ng-scope')])["+i+"]/following::button[@ng-dblclick='grid.appScope.start($event)']"));
			action.doubleClick(editButton).build().perform();
			try
			{
		    WebElement ele1=driver.findElement(By.xpath("//*[@value='"+Text+"']"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].value=arguments[1]", ele1,newText);
			test.log(LogStatus.PASS, "Typed new Value");
			WebElement Cancel=driver.findElement(By.xpath("(//*[@value='"+Text+"']/following::button[text()='Cancel']"));
			Thread.sleep(2000);
			js.executeScript("arguments[0].click();", Cancel);
			test.log(LogStatus.PASS, "Clicked On Cancel");
			Thread.sleep(9000);
			}
			catch(Exception e)
			{
				System.out.println("Exception encountered");
			}
			break;
		}
		//System.out.println("Text is: "+ele.getText());
		}
	}
}
