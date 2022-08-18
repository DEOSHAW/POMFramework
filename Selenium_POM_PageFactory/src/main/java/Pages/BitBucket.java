package Pages;

import java.time.Duration;

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

public class BitBucket {
	WebDriver driver;
	ExtentTest test;
	
	public BitBucket(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//a[text()='Product Guide'])[1]")
	WebElement productGuideLink;
	@FindBy(xpath="(//a[text()='Brief overview of Bitbucket'])[1]")
	WebElement bitBucketOverviewLink;
	@FindBy(xpath="//p[contains(text(),'Bitbucket Cloud is a Git based')]")
	WebElement bitBucketOverview;
	
	void getProductOverview() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		Actions actions=new Actions(driver);
		actions.moveToElement(productGuideLink).pause(Duration.ofMillis(800)).click(bitBucketOverviewLink).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(bitBucketOverview));
		js.executeScript("alert(arguments[0])", bitBucketOverview.getText());
		test.log(LogStatus.PASS, "Overview of Bitbucket displayed");
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
