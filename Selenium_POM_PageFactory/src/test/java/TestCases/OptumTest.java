package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Optum;
import utilities.seleniumUtilities;

public class OptumTest extends Baseclass {
	
	
	
	@Test
	void testOptum() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.optum.com/", driver);
		Optum ob=Optum.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Optum.class.getDeclaredMethod("getInsightsPublishedByOptum");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
		
	}

}
