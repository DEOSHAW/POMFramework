package TestCases;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UltimateQA;
import utilities.seleniumUtilities;

public class UltimateQATest extends Baseclass 
{
	
	@Test
	void getPricingOfUltimateQAPlans() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://ultimateqa.com/automation/?ref=hackernoon.com", driver);
		test.log(LogStatus.PASS, "Launched Browser");
		UltimateQA ob=UltimateQA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UltimateQA.class.getDeclaredMethod("getPricingOfPlans");
		m.setAccessible(true);
		HashMap<String,String> Plans=(HashMap<String, String>) m.invoke(ob);
		StringBuilder plansMap=new StringBuilder();
		for(Map.Entry<String, String> map:Plans.entrySet())
		{
			System.out.println(map.getKey()+"==>"+map.getValue());
			plansMap.append(map.getKey()+"==>"+map.getValue());
			plansMap.append("\n");
			
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", plansMap.toString());
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Displayed pricing of all the plans");
		test.log(LogStatus.PASS, "Browser Closed");
		
	}

}
