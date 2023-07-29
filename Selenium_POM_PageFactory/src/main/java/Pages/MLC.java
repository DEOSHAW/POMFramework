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

public class MLC {
	WebDriver driver;
	ExtentTest test;
	
	public MLC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="(//a[text()='Teams'])[1]")
	WebElement teamsLink;
	
	@FindBy(xpath="//div[@class='team__card team__card--unicorns']")
	WebElement SFUnicornsTeamLink;
	
	@FindBy(xpath="//a[text()='Roster']")
	WebElement rosterLink;
	@FindBy(css="p.roster__card--name")
	List<WebElement> Players;
	
	
	
	private void getSFUnicornsRoster() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", teamsLink);
		js.executeScript("arguments[0].click();", SFUnicornsTeamLink);
		js.executeScript("arguments[0].scrollIntoView();", rosterLink);
		js.executeScript("arguments[0].click();", rosterLink);
		test.log(LogStatus.PASS, "Navigated to Team roster page");
		
		for(WebElement Player:Players)
		{
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", Player);
			js.executeScript("window.scrollBy(0,50)");
			Thread.sleep(500);
		}
		test.log(LogStatus.PASS, "Players of the Team displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}
	
	

}
