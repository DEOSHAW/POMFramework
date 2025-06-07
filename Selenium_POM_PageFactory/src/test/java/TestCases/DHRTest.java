package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.DHR;
import utilities.seleniumUtilities;

public class DHRTest extends Baseclass
{
	@Test
	void getDHRPortalImage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://dhr.indianrailways.gov.in/",driver);
		DHR ob=DHR.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=DHR.class.getDeclaredMethod("getPortalImage");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "DHR portal image captured");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
