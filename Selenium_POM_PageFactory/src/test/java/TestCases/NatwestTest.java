package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Natwest;
import utilities.seleniumUtilities;

public class NatwestTest extends Baseclass {
	
	
	
	@Test
	void testCareerSense() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.natwestgroup.com/", driver);
		Natwest ob=Natwest.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Natwest.class.getDeclaredMethod("getCareerSense");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
