package Pages;

import java.time.Duration;

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

public class WGR {
	
	WebDriver driver;
	ExtentTest test;
	
	public WGR(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//button[contains(text(),'Accept All Cookies ')]")
	WebElement cookiesElement;
	
	
	void getTop5InGolfRankings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(cookiesElement));
		cookiesElement.click();
		test.log(LogStatus.PASS, "Accepted cookies");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(int i=1;i<=5;i++)
		{
		WebElement golfPlayer=driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td[5]"));
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", golfPlayer);
		Thread.sleep(800);
		
		}
		test.log(LogStatus.PASS, "Top 5 Golfers revealed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
