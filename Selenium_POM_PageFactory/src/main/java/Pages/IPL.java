package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class IPL {
	WebDriver driver;
	ExtentTest test;
	
	public IPL(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//*[contains(text(),'2021 Leaders')]")
	WebElement Leaders;
	@FindBy(xpath="//*[@class='playercard-box']/child::div[2]")
	List<WebElement> awardName;
	@FindBy(xpath="//*[@class='playercard-box']/child::div[3]/p")
	List<WebElement> playerFirstName;
	@FindBy(xpath="//*[@class='playercard-box']/child::div[3]/div")
	List<WebElement> playerLastName;
	
	
	private void get2021LeadingPlayers() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", Leaders);
		test.log(LogStatus.PASS, "Scrolled to leading players section");
		StringBuilder playersList=new StringBuilder();
		int count=awardName.size();
		for(int i=0;i<count;i++)
		{
			if(i==count-1)
			{
				playersList.append("Sanju Samson"+"==>"+awardName.get(i).getText());
				playersList.append("\n");
				
			
			}
			else
			{
			playersList.append(playerFirstName.get(i).getText()+" "+playerLastName.get(i).getText()+"==>"+awardName.get(i).getText());
			playersList.append("\n");
			}
		}
		
		js.executeScript("alert(arguments[0])", playersList.toString());
		test.log(LogStatus.PASS, "Leading players of 2021 displayed");
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		Thread.sleep(900);
		test.log(LogStatus.PASS, "Test ended");
		System.out.println(playersList);
		
		
	}

}
