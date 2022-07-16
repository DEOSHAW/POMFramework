package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.AFL;
import utilities.seleniumUtilities;

public class AFL_Test extends Baseclass {
	
	
	@Test
	void getAFLTeamNames() throws Exception
	{
		
		
		seleniumUtilities.LaunchBrowser("https://www.afl.com.au/", driver);
		AFL ob=AFL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=AFL.class.getDeclaredMethod("getListOfClubs");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
