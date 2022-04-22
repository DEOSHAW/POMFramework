package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.EPAM;
import utilities.seleniumUtilities;

public class EPAM_Test extends Baseclass {
	
	
	
	@Test
	void testEPAMUI() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.epam.com/", driver);
		EPAM ob=EPAM.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=EPAM.class.getDeclaredMethod("searchOnEPAMPortal");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
