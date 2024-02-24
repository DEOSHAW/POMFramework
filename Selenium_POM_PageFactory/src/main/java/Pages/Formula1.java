package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Formula1 
{
	WebDriver driver;
	ExtentTest test;
	
	public Formula1(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//button[@aria-label='ACCEPT ALL']")
	WebElement acceptAllbutton;
	@FindBy(xpath="(//span[text()='Results'])[1]")
	WebElement resultsLink;
	@FindBy(xpath="(//a[contains(@href,'driver-standings.html')])[1]")
	WebElement driversStandingsLink;
	@FindBy(xpath="//table[@class='resultsarchive-table']//tr")
	List<WebElement> allRows;
	@FindBy(xpath="//table[@class='resultsarchive-table']//tr[1]//td")
	List<WebElement> allColumns;
	String tableElement="//table[@class='resultsarchive-table']//tr[%s]//td[%s]";
	
	void getDriversStandings() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.switchTo().frame("sp_message_iframe_1033523");
		wait.until(ExpectedConditions.visibilityOf(acceptAllbutton)).click();
		driver.switchTo().defaultContent();
		Actions actions=new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(resultsLink));
		actions.moveToElement(resultsLink).build().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driversStandingsLink);
		int rowNum=allRows.size()-1;
		int colNum=allColumns.size();
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=1;j<=colNum;j++)
			{
				String xpath=String.format(tableElement, i,j);
			    String tableValue=driver.findElement(By.xpath(xpath)).getText();
			    if(!tableValue.isEmpty())
			    {
			    System.out.print(tableValue+"  ");
			    }
			}
			System.out.println();
		}
		
	}
	
	

}
