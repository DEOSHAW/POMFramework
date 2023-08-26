package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MLS 
{
	WebDriver driver;
	ExtentTest test;
	
	
	public MLS(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[text()='Standings'])[1]")
	WebElement standingsLink;
	
	@FindBy(xpath="//*[contains(text(),'Eastern Conference')]")
	WebElement standingsLabel;
	
	@FindBy(xpath="(//table[@role='table'])[1]//tbody//tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="(//table[@role='table'])[1]//tbody//tr[1]//td")
	List<WebElement> tableColumns;
	
	
	void getStandings() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		standingsLink.click();
		test.log(LogStatus.PASS, "Navigated to Standings page");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(standingsLabel));
		int rowNum=tableRows.size();
		int colNum=tableRows.size();
		StringBuffer standings=new StringBuffer();
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=2;j++)
			{
				standings.append(driver.findElement(By.xpath("(//table[@role='table'])[1]//tbody//tr["+i+"]//td["+j+"]")).getText()+" ");
				
			}
			standings.append("\n");
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", standings.toString());
		test.log(LogStatus.PASS, "MLS Standings displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
