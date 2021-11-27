package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.AADHAR;
import utilities.seleniumUtilities;

public class AADHAR_TEST extends Baseclass {
	
	
	@Test
	void testAADHAR() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://uidai.gov.in/", driver);
		AADHAR ob=AADHAR.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=AADHAR.class.getDeclaredMethod("getAADHARTelecast");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
