package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.DisneyLand;
import utilities.seleniumUtilities;

public class DisneyLandTest extends Baseclass {
	
	
	
	@Test
	void getColoursFromDisneyLand() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://disneyland.disney.go.com/destinations/disneyland/", driver);
		DisneyLand ob=DisneyLand.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=DisneyLand.class.getDeclaredMethod("getColours");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
