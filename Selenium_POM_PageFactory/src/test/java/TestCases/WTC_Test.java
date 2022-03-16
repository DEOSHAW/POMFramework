package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.WTC;
import utilities.seleniumUtilities;

public class WTC_Test extends Baseclass {
	
	
	
	@Test
	void getRankings() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.cricbuzz.com/cricket-stats/points-table/test/world-test-championship-2021-2023", driver);
		WTC ob=WTC.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=WTC.class.getDeclaredMethod("getStandings");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
