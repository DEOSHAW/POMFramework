package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.HCL;
import utilities.seleniumUtilities;

public class HCL_GetIndustryDomains extends Baseclass {
	
	
	
	@Test
	void getIndustryDomains() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.hcltech.com/", driver);
		HCL ob=HCL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=HCL.class.getDeclaredMethod("getDomains");
		m.setAccessible(true);
		m.invoke(ob);
		
	}
	

}
