package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MLC;
import utilities.seleniumUtilities;

public class MLCTest extends Baseclass {
	
	
	
	@Test
	void getMLCTeamRoster() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.majorleaguecricket.com/", driver);
		MLC ob=MLC.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MLC.class.getDeclaredMethod("getSFUnicornsRoster");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
