package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DPWorldTour 
{
	WebDriver driver;
	ExtentTest test;
	
	public DPWorldTour(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Agree & Close')]")
	WebElement cookiesLink;
	
	@FindBy(xpath="(//a[normalize-space(text())='Rankings'])[1]")
	WebElement rankingsLink;
	
	@FindBy(xpath="//h3[contains(text(),'Top Five on Tour')]")
	WebElement rankingsLabel;
	
	@FindBy(xpath="//span[contains(@class,'player-card__first-name player-card')]")
	List<WebElement> playerFirstName;
	
	@FindBy(xpath="//span[contains(@class,'player-card__last-name player-card')]")
	List<WebElement> playerLastName;
	
	void getTop5OnTour() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		cookiesLink.click();
		rankingsLink.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(rankingsLabel));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		System.out.println("Top 5 players are: ");
		int count=1;
		for(int i=0;i<playerFirstName.size();i++)
		{
			
			String playerFullName=playerFirstName.get(i).getText()+" "+playerLastName.get(i).getText();
			if(!playerFullName.isBlank()&& count<6)
			{
			System.out.println(playerFullName);
			count++;
			}
			
		}
		test.log(LogStatus.PASS, "Top 5 players displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
