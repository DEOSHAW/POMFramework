package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FIBA {
	WebDriver driver;
	ExtentTest test;
	
	public FIBA(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[text()='Men' and @href='/rankingmen']")
	WebElement rankingsMen;
	
	void getTop10Rankings()
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.click(rankingsMen).perform();
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!window.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		test.log(LogStatus.PASS, "Switched to Rankings page");
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(i+". "+driver.findElement(By.xpath("(//table[contains(@class,'fiba_ranking_table')])[1]//tbody//tr["+i+"]//td[2]//span")).getText());
		}
		
		test.log(LogStatus.PASS, "Top 10 countries in FIBA rankings displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
