package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PluralSight {
	WebDriver driver;
	ExtentTest test;
	
	public PluralSight(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@data-aa-title='ps-nav-View plans']")
	WebElement viewPlansLink;
	
	@FindBy(xpath="//a[@data-aa-title='view-skills-plans']")
	WebElement viewSkillsPlan;
	
	@FindBy(xpath="//div[@class='pricing_display']/h2[contains(text(),'Standard') or contains(text(),'Premium')]/parent::div")
	List<WebElement> planCards;
	
	void getIndividualPlans() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		viewPlansLink.click();
		js.executeScript("arguments[0].scrollIntoView();",viewSkillsPlan);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-200)");
		viewSkillsPlan.click();
		test.log(LogStatus.PASS, "Navigted to skill plans section");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		for(WebElement Card:planCards)
		{
			
			System.out.println("Plan Name: "+Card.findElement(By.tagName("h2")).getText());
			System.out.print("==>Rs. "+Card.findElement(By.cssSelector("div.pricing-annual span.curr-major")).getText()+" per year");
			//System.out.print("==>Rs. "+Card.findElement(By.xpath("//div[@class='pricing-annual']//span[@class='curr-major']")).getText()+" per year");
			System.out.println("\n");
		}
		test.log(LogStatus.PASS, "Plans displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
	}

}
