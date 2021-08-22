package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Coop;
import utilities.seleniumUtilities;

public class CoopTest extends Baseclass {
	
	
	
	@Test
	void testCoopSite() throws Exception 
	{
		seleniumUtilities.LaunchBrowser("http://coop.apps.symfonycasts.com/api", driver);
		Coop.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).gettheListOfEndPoints();
		
		
	}

}
