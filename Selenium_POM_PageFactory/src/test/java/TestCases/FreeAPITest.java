package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.FreeAPI;
import utilities.seleniumUtilities;

public class FreeAPITest extends Baseclass {
	
	
	@Test
	void testFreeAPI() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://apipheny.io/free-api/", driver);
		FreeAPI.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).getAllTheFeatures();
	}

}
