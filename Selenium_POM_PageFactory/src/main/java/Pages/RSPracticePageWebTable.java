package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RSPracticePageWebTable {
	
	
	WebDriver driver;
	ExtentTest test;
	public RSPracticePageWebTable(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='tableFixHead']//tbody//tr")
	List<WebElement> allRows;
	@FindBy(xpath="//*[@class='tableFixHead']//tbody//tr[1]//td")
	List<WebElement> allColumns;
	
	
	
	void printWebTable() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		StringBuilder webTable=new StringBuilder();
		String st=new String(webTable);
		
		int rowCount=allRows.size();
		int colNum=allColumns.size();
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				webTable.append(driver.findElement(By.xpath("//*[@class='tableFixHead']//tbody//tr["+i+"]//td["+j+"]")).getText()+" ");
			}
			webTable.append("\n");
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String wt=new String(webTable);
		js.executeScript("alert(arguments[0])", wt);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Web table Printed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
