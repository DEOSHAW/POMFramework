package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Wimbledon;
import utilities.seleniumUtilities;

public class WimbledonTest extends Baseclass {
	
	
	
	@Test
	void getWimbledonPlayersDetails() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.wimbledon.com/", driver);
		
		Wimbledon ob=Wimbledon.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Wimbledon.class.getDeclaredMethod("getPlayerDetails");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
