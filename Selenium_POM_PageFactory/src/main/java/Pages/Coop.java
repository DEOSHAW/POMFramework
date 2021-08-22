package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Coop {
	
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	
	public Coop(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void gettheListOfEndPoints() throws Exception
	{
		StringBuilder builder=new StringBuilder();
		js=(JavascriptExecutor)driver;
		test.log(LogStatus.PASS, "Test Started");
		
		int rowNum=driver.findElements(By.xpath("//*[@class='table']//tbody//tr")).size();
		int colNum=driver.findElements(By.xpath("//*[@class='table']//tbody//tr[1]//td")).size();
		test.log(LogStatus.PASS, "Got the dimension of API table");
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum-1;j++)
			{
				builder.append(driver.findElement(By.xpath("//*[@class='table']//tbody//tr["+i+"]//td["+j+"]")).getText()+" | ");
				
			}
			builder.append("\n");
	    } 
		
		    js.executeScript("alert(arguments[0])", builder.toString());
		    test.log(LogStatus.PASS, "Displayed the list of APIs");
		    Thread.sleep(2000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(800);
		    
		    System.out.println(builder);
		    test.log(LogStatus.PASS, "Test Ended");

      }
}
