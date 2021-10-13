package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ICC {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	
	public ICC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void getRankings() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		StringBuilder teamsTable=new StringBuilder();
		int rowNum=driver.findElements(By.xpath("//*[@class='table']/tbody//tr")).size();
		int colNum=driver.findElements(By.xpath("//*[@class='table']/tbody//tr[1]//td")).size();
		for(int i=1;i<=rowNum;i++)
		{
		    for(int j=1;j<=colNum;j++)
		    {
		       String Value=driver.findElement(By.xpath("//*[@class='table']/tbody//tr["+i+"]//td["+j+"]")).getText();
		       teamsTable.append(Value);
		       teamsTable.append(" ");
		    }
		    teamsTable.append("\n");
		}
		js.executeScript("alert(arguments[0])", teamsTable.toString());
		test.log(LogStatus.PASS, "Rankings displayed");
		System.out.println(teamsTable);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
	}

}
