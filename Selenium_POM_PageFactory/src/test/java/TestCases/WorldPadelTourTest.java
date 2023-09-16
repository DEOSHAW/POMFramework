package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.WorldPadelTour;
import utilities.seleniumUtilities;

public class WorldPadelTourTest extends Baseclass {
	
	@Test
	void getWPTRankings() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://worldpadeltour.com/en", driver);
		WorldPadelTour ob=WorldPadelTour.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=WorldPadelTour.class.getDeclaredMethod("getRankings");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
