package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.WGR;
import utilities.seleniumUtilities;

public class WGRTest extends Baseclass {
	
	
	@Test
	void getTop4InWGR() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.owgr.com/current-world-ranking", driver);
		WGR ob=WGR.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=WGR.class.getDeclaredMethod("getTop5InGolfRankings");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
