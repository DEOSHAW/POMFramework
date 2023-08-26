package Pages;

import java.time.Duration;

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
import com.relevantcodes.extentreports.LogStatus;

public class FreeAPI {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	Actions actions;
	JavascriptExecutor js;
	
	public FreeAPI(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@title='Features']")
	WebElement featureMenu;
	
	public void getAllTheFeatures() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		StringBuilder featureList=new StringBuilder();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOf(featureMenu));
		actions=new Actions(driver);
		actions.moveToElement(featureMenu).perform();
		test.log(LogStatus.PASS, "Hovered over feature menu");
		for(int i=1;i<=13;i++)
		{
			featureList.append(driver.findElement(By.xpath("//*[@class=' dropdown-menu menu-depth-2nd']//child::li["+i+"]//a")).getText());
			featureList.append("\n");
		}
		
	    js.executeScript("alert(arguments[0])", featureList.toString());
	    test.log(LogStatus.PASS, "List of features displayed");
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(1500);
	    test.log(LogStatus.PASS, "Test Ended");
	    
		
		
	}

}
