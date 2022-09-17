package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LegendsLeague {
	
	WebDriver driver;
	ExtentTest test;
	
	public LegendsLeague(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Team']")
	WebElement teamDropDown;
	@FindBy(xpath="//a[text()='Team']/following-sibling::ul//li/a")
	List<WebElement> listOfTeams;
	
	
	void getTeamNames()
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(teamDropDown).perform();
		test.log(LogStatus.PASS, "Hovered over Team dropdown");
		for(WebElement team:listOfTeams)
		{
			System.out.println(team.getText());
			
		}
		test.log(LogStatus.PASS, "Teams displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
