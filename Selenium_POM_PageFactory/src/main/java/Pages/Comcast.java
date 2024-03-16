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

public class Comcast
{
	WebDriver driver;
	ExtentTest test;
	
	public Comcast(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Company']")
	WebElement companyMenu;
	@FindBy(xpath="//a[text()='Overview']")
	WebElement overviewLink;
	@FindBy(xpath="//div[@class=' post-content']/p[contains(text(),'technology company')]")
	WebElement companyOverview;
	String getCompanyOverview() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(companyMenu).perform();
		Thread.sleep(2000);
		overviewLink.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(companyOverview));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].innerHTML;", companyOverview);
		
	}

}
