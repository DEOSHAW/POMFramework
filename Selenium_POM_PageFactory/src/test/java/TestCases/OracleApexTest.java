package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.OracleApex;
import utilities.seleniumUtilities;

public class OracleApexTest extends Baseclass {
	
	
	
	@Test
	void testOracleApexSQLFeature() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://apex.oracle.com/en/", driver);
		OracleApex ob=OracleApex.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ob.getClass().getDeclaredMethod("executeQueryInOracleApex");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
