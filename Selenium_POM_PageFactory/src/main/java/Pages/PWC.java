package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

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



public class PWC {
	
	static WebDriver driver;
	static ExtentTest test;
	static WebDriverWait wait;
	static JavascriptExecutor js;
	public PWC(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[normalize-space(text())='Menu']")
	WebElement hamMenu;
	@FindBy(xpath="//span[normalize-space(text())='Careers']")
	WebElement careersLink;
	
	public void ExploreCareerBenefitsAtPWC() throws InterruptedException
	{
		StringBuilder careerPerks=new StringBuilder();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		js=(JavascriptExecutor)driver;
		test.log(LogStatus.PASS, "Test started");
		test.log(LogStatus.PASS, "Clicked on hamburger link");
		wait.until(ExpectedConditions.visibilityOf(hamMenu)).click();
		test.log(LogStatus.PASS, "Clicked on careers link");
		wait.until(ExpectedConditions.visibilityOf(careersLink)).click();
		//Find all the benefits of working at PWC
		List<WebElement> careerBenefits=driver.findElements(By.xpath("//*[@class='secnav-tabs__tab-title']"));
		Iterator<WebElement> itr=careerBenefits.iterator();
		while(itr.hasNext())
		{
			careerPerks.append(itr.next().getText());
			careerPerks.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", careerPerks.toString());
		test.log(LogStatus.PASS, "Career perks displayed");
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
