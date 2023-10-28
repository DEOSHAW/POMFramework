package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NextGenAiProgressBar 
{
	WebDriver driver;
	ExtentTest test;
	
	public NextGenAiProgressBar(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="#start")
	WebElement startButton;
	@FindBy(xpath="//div[@id='myBar']")
	WebElement progressBar;
	
	void validateProgressBar() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		startButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(progressBar, "style", "100%"));
		test.log(LogStatus.PASS, "Progress bar reached 100%");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid yellow; background:Black')", progressBar);
		test.log(LogStatus.PASS, "Progress bar highlighted");
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
