package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MLF {
	WebDriver driver;
	ExtentTest test;
	
	public MLF(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'Bass Pro Tour') and @class='title']")
	WebElement bassProTour;
	@FindBy(xpath="//*[contains(text(),'Bally Bet AOY')]")
	WebElement tourStandings;
	@FindBy(xpath="//*[contains(@href,'standings') and contains(text(),'View All')]")
	WebElement viewAll;
	
	void getTop10Angelers() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		//bassProTour.click();
		//Thread.sleep(600000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", tourStandings);
		//js.executeScript("arguments[0].click();", viewAll);
		test.log(LogStatus.PASS, "Navigated to standings");
		StringBuilder Standings=new StringBuilder();
		String value;
		for(int i=1;i<=10;i++)
		{
			for(int j=1;j<=4;j++)
			{
				value=driver.findElement(By.xpath("//*[@class='table']//tr["+i+"]/td["+j+"]")).getText();
				Standings.append(value+" ");
				
			}
			Standings.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", Standings.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Top 10 Angelers displayed");
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		System.out.println(Standings);
		Thread.sleep(1000);
		
	}

}
