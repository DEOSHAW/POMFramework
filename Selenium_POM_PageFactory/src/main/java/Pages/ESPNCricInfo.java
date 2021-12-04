package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ESPNCricInfo {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	
	public ESPNCricInfo(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//*[@class='engineTable']//tbody/tr/td/a[contains(@href,'player')]/parent::td")
	List<WebElement> allCountries;
	@FindBy(xpath="//*[@class='engineTable']//tbody/tr/td/a[contains(@href,'player')]")
	List<WebElement> allPlayers;
	
	@FindBy(xpath="//*[@class='engineTable']//tbody/tr/td/a[contains(@href,'player')]/parent::td/following-sibling::td[5]")
	List<WebElement> allRuns;
	
	
	void getTopRunGetters() throws Exception
	{
		String countryName;
		
		test.log(LogStatus.PASS, "Test Started");
		js=(JavascriptExecutor)driver;
		for(int i=0;i<allPlayers.size();i++)
		{
			countryName=allCountries.get(i).getText();
			if(countryName.trim().contains("INDIA"))
			{
				js.executeScript("window.scrollBy(0,80)");
				Thread.sleep(1500);
				js.executeScript("arguments[0].style.border='3px solid red'", allPlayers.get(i));
				Thread.sleep(500);
				js.executeScript("arguments[0].style.border='3px solid red'", allRuns.get(i));
				Thread.sleep(500);
				
			}
			test.log(LogStatus.PASS, "Highest run getters in Tests for India highlighted");
		}
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
