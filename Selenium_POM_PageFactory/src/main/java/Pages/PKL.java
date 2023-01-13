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

public class PKL {
	WebDriver driver;
	ExtentTest test;
	
	
	public PKL(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@title='Standings']")
	WebElement standingsLink;
	
	@FindBy(xpath="//div[@class='table-data team']")
	List<WebElement> teamNames;
	
	
	void getStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		standingsLink.click();
		test.log(LogStatus.PASS, "Clicked on Standings link");
		Iterator<WebElement> itr=teamNames.iterator();
		StringBuilder teams=new StringBuilder();
		while(itr.hasNext())
		{
			
			teams.append(itr.next().getText());
			teams.append("\n");
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", teams.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Team Standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
	}

}
