package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProKabaddi {
	WebDriver driver;
	ExtentTest test;
	
	public ProKabaddi(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@title='Teams']")
	WebElement teamLink;
	
	@FindBy(how=How.CSS,using="div.card-text")
	List<WebElement> teamsList;
	
	void getTeamNames() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		teamLink.click();
		StringBuilder teamList=new StringBuilder();
		for(WebElement ele:teamsList)
		{
			List<WebElement> teamName=ele.findElements(By.tagName("p"));
			teamList.append(teamName.get(0).getText()+" "+teamName.get(1).getText());
			teamList.append("\n");
			System.out.println(teamName.get(0).getText()+" "+teamName.get(1).getText());
		}
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", teamList.toString());
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "List of Teams displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
