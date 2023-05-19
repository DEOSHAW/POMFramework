package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MLS;
import utilities.seleniumUtilities;

public class MLSTest extends Baseclass
{
	
	@Test
	void getMLSStandings() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.mlssoccer.com/", driver);
		MLS ob=MLS.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MLS.class.getDeclaredMethod("getStandings");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
