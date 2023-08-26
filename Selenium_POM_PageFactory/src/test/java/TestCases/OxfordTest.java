package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Oxford;
import utilities.seleniumUtilities;

public class OxfordTest extends Baseclass {
	
	
	@Test
	void getOxfordAdmissionStatistics() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.ox.ac.uk/", driver);
		Oxford ob=Oxford.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ob.getClass().getDeclaredMethod("getAdmissionStatistics");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
