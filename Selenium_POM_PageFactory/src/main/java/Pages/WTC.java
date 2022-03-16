package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WTC {
	WebDriver driver;
	ExtentTest test;
	
	
	public WTC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	void getStandings()
	{
		test.log(LogStatus.PASS, "Test started");
		int rowNum=driver.findElements(By.xpath("//*[@class='table cb-srs-pnts']//tbody//tr")).size();
		int colNum=driver.findElements(By.xpath("//*[@class='table cb-srs-pnts']//tbody//tr[1]/td")).size();
		
		for(int i=1;i<=rowNum;i++ )
		{
			for(int j=1;j<=colNum;j++)
			{
				System.out.print(driver.findElement(By.xpath("//*[@class='table cb-srs-pnts']//tbody//tr["+i+"]/td["+j+"]")).getText()+" ");
			}
			System.out.println();
		}
		test.log(LogStatus.PASS, "Standings displayed");
		test.log(LogStatus.PASS, "Test ended");
	}

}
