package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Bundesliga {
	WebDriver driver;
	ExtentTest test;
	
	public Bundesliga(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//button[text()='Accept All Cookies']")
	WebElement cookiesButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Table')]")
	WebElement table;
	
	@FindBy(how=How.XPATH,using="(//*[@class='table'])[1]//tbody//tr")
	List<WebElement> allRows;
	
	@FindBy(how=How.XPATH,using="(//*[@class='table'])[1]//tbody//tr//td[5]//div")
	List<WebElement> teamStandings;
	
	
	
	void getStandings() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		cookiesButton.click();
		table.click();
		
		int rowCount=allRows.size();
		for(WebElement team:teamStandings)
		{
			System.out.println(team.getAttribute("title"));
		}
		
		test.log(LogStatus.PASS, "Bundesliga standings displayed");
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
