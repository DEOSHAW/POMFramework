package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class UITestingPlayground_DynamicTable {
	WebDriver driver;
	ExtentTest test;
	
	
	public UITestingPlayground_DynamicTable(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//span[@role='cell' and text()='Chrome']/parent::div/child::span[contains(text(),'%')]")
	WebElement cpuLoadForChrome;
	
	@FindBy(how=How.XPATH,using="//p[contains(text(),'Chrome CPU')]")
	WebElement displayedCpuLoadForChrome;
	
	
	String getValueOfCpuLoadFromTable()
	{
		
		return cpuLoadForChrome.getText();
		
		
	}
	
	public String getDisplayedValueOfCpuLoad()
	{
		
		return displayedCpuLoadForChrome.getText().replaceAll("[A-Za-z]", "").replace(":", "").trim();
		
		
	}

}
