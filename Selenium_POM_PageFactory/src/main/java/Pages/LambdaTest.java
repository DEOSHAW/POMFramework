package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LambdaTest {
	
	WebDriver driver;
	ExtentTest test;
	

	public LambdaTest(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[contains(text(),'Follow On Twitter')]")
	WebElement followOnTwitter;
	@FindBy(xpath="//*[contains(text(),'LambdaTest is a continuous quality testing')]")
	WebElement twitterInfo;
	
	void getInfoFromTwitter() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		String parentWinHandle=driver.getWindowHandle();
		test.log(LogStatus.PASS, "Extracted parent window handle: "+parentWinHandle);
		followOnTwitter.click();
		Set<String> allWinHandles=driver.getWindowHandles();
		test.log(LogStatus.PASS, "Extracted all window handles: "+allWinHandles);
		Iterator<String> itr=allWinHandles.iterator();
		while(itr.hasNext())
		{
			String currentWindow=itr.next();
			if(!currentWindow.equalsIgnoreCase(parentWinHandle))
			{
				driver.switchTo().window(currentWindow);
				break;
			}
		}
		driver.manage().window().maximize();
		test.log(LogStatus.PASS, "Switched to Twitter window");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(twitterInfo));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", twitterInfo);
		test.log(LogStatus.PASS, "Highlighted information on twitter profile");
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Test Ended");
	}

}
