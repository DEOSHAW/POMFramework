package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.HCLFoundation;
import utilities.seleniumUtilities;

public class HCLFoundationTest extends Baseclass {
	
	
	
	@Test
	void getFlagshipProgrammes() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.hclfoundation.org/", driver);
		HCLFoundation ob=HCLFoundation.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=HCLFoundation.class.getDeclaredMethod("getCSRProgrammes");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
