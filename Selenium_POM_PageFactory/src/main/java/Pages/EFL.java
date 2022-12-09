package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EFL {
	WebDriver driver;
	ExtentTest test;
	
	public EFL(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@href='/clubs-and-competitions/']")
	WebElement competitionsMenu;
	@FindBy(xpath="//button[text()='Accept All Cookies']")
	List<WebElement> acceptCookies;
	
	
	void getCompetitionNames()
	{
		test.log(LogStatus.PASS, "Test Started");
		if(acceptCookies.size()>0)
		{
		acceptCookies.get(0).click();
		}
		test.log(LogStatus.PASS, "Accepted Cookies");
		Actions actions=new Actions(driver);
		actions.moveToElement(competitionsMenu).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		for(int i=2;i<=10;i++)
		{
			WebElement competition=driver.findElement(By.xpath("(//*[@href='/clubs-and-competitions/']/following::li/a)["+i+"]"));
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", competition);
			System.out.println(js.executeScript("return arguments[0].innerHTML", competition));
		}
		
		test.log(LogStatus.PASS, "List of competitions displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}
	

}
