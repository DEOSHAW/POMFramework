package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class USOpenGolf 
{
	WebDriver driver;
	ExtentTest test;
	
	
	public USOpenGolf(WebDriver driver,ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.CSS,using="span.mini-leader-board_cta_text")
	WebElement leaderBoardLink;
	@FindBy(css="li.opens-player-cell")
	WebElement playerHeader;
	@FindBy(xpath="//div[@aria-label='entering into table']//li[contains(@aria-label,'player cell data')]")
	List<WebElement> playersRanking;
	
	
	void getTop10InTheLeaderBoard() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		leaderBoardLink.click();
		test.log(LogStatus.PASS, "Navigated to leaderboard section");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(playerHeader));
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<10;i++)
		{
			sb.append((i+1)+"==>"+playersRanking.get(i).getText());
			sb.append("\n");
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", sb.toString());
		test.log(LogStatus.PASS, "Top 10 players in Leaderboard displayed");
		Thread.sleep(2000);
		//driver.switchTo().alert().accept();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(200);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
