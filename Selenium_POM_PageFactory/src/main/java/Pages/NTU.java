package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class NTU {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	
	public NTU(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'QS Top 50 under 50')]")
	WebElement achievementElement;
	@FindBy(xpath="//*[@class='figure']")
	List<WebElement> firstAchievementElement;
	@FindBy(xpath="//*[@class='figure']/following-sibling::span")
	List<WebElement> secondAchievementElement;
	
	
	void getListOfNTUAchievements() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", achievementElement);
		test.log(LogStatus.PASS, "Scrolled to the achievements section");
		StringBuilder achievementList=new StringBuilder();
		for(int i=0;i<firstAchievementElement.size();i++)
		{
			String Achievement=firstAchievementElement.get(i).getText()+" "+secondAchievementElement.get(i).getText();
		    achievementList.append(Achievement);
		    achievementList.append("\n");
		    
		}
		
		js.executeScript("alert(arguments[0])", achievementList.toString());
		System.out.println(achievementList.toString());
		test.log(LogStatus.PASS, "List of achievements displayed");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
