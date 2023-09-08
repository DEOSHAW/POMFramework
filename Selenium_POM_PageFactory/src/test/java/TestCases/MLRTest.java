package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MLR;
import utilities.seleniumUtilities;

public class MLRTest extends Baseclass {
	
	@Test
	void getCSSValuesOfMLRTeams() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.majorleague.rugby/", driver);
		MLR ob=MLR.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MLR.class.getDeclaredMethod("getCSSValuesOfTeams");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
