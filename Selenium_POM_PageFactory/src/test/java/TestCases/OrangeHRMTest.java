package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.OrangeHRM;
import utilities.seleniumUtilities;

public class OrangeHRMTest extends Baseclass {
	
	
	
	@Test
	void testOrangeHRM() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.orangehrm.com/", driver);
		OrangeHRM ob=OrangeHRM.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=OrangeHRM.class.getDeclaredMethod("registerOnOrangeHRM");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
