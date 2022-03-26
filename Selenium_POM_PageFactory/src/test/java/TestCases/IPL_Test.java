package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.IPL;
import utilities.seleniumUtilities;

public class IPL_Test extends Baseclass {
	
	
	
	@Test
	void get2021Leaders() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.iplt20.com/", driver);
		IPL ob=IPL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=IPL.class.getDeclaredMethod("get2021LeadingPlayers");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
