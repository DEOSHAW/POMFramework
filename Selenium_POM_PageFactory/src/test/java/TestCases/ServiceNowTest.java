package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ServiceNow;
import utilities.seleniumUtilities;

public class ServiceNowTest extends Baseclass {
	
	
	@Test
	void testServiceNow() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.servicenow.com/", driver);
		ServiceNow.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).getServiceNowProducts();
	}

}
