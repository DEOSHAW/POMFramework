package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GBU;
import utilities.seleniumUtilities;

public class GBU_Test extends Baseclass {
	
	
	
	@Test
	void getTheNameOfGBUSchools() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.gbu.ac.in/", driver);
		GBU ob=GBU.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GBU.class.getDeclaredMethod("getTheListOfSchools");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
