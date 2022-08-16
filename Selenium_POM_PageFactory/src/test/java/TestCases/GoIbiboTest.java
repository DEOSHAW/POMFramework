package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.GoIbibo;
import utilities.seleniumUtilities;

public class GoIbiboTest extends Baseclass {
	
	
	@Test
	void searchFlightsOnGoIbibo() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.goibibo.com/", driver);
		GoIbibo ob=GoIbibo.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GoIbibo.class.getDeclaredMethod("searchFlights",String.class,String.class);
		m.setAccessible(true);
		m.invoke(ob,seleniumUtilities.getDataForKey("SOURCE_LOCATION"),seleniumUtilities.getDataForKey("DEST_LOCATION"));
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
