package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ICC;
import utilities.seleniumUtilities;

public class ICCTest extends Baseclass {
	
	@Test
	void getTestTeamsRankings() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.icc-cricket.com/rankings/mens/team-rankings/test", driver);
		ICC ob=ICC.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ICC.class.getDeclaredMethod("getRankings");
		m.invoke(ob);
		
	}

}
