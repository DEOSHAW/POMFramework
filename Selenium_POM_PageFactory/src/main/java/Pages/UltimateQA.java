package Pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class UltimateQA 
{
	WebDriver driver;
	ExtentTest test;
	
	public UltimateQA(WebDriver driver,ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath="//a[contains(text(),'Fake Pricing Page')]")
	WebElement fakePricingLink;
	
	@FindBy(css="div.et_pb_pricing_heading h4")
	List<WebElement> planNames;
	
	@FindBy(css="span.et_pb_sum")
	List<WebElement> planPrices;
	
	HashMap<String,String> getPricingOfPlans()
	{
		HashMap<String,String> plansMap=new HashMap<String,String>();
		fakePricingLink.click();
		for(int i=0;i<planNames.size();i++)
		{
			plansMap.put(planNames.get(i).getText(), planPrices.get(i).getText());
			
		}
		
		return plansMap;
		
	}

}
