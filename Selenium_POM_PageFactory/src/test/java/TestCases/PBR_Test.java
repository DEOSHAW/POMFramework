package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PBR;
import utilities.seleniumUtilities;

public class PBR_Test extends Baseclass {
	
	@Test
	void testPBR() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://pbr.com/", driver);
		PBR ob=PBR.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=PBR.class.getDeclaredMethod("getPlayersStandings");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
