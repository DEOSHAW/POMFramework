package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.HoneyWell;
import utilities.seleniumUtilities;

public class HoneyWellTest extends Baseclass {
	
	
	
	@Test
	void getHoneyWellBusinessLines() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.honeywell.com/us/en", driver);
		HoneyWell ob=HoneyWell.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=HoneyWell.class.getDeclaredMethod("getBusinessLines");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}
	
	
	

}
