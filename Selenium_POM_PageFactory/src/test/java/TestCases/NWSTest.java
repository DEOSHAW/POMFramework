package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NWS;
import utilities.seleniumUtilities;

public class NWSTest extends Baseclass
{
	@Test
	void getNWSCertifiedWeatherData() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.weather.gov/documentation/services-web-api", driver);
		NWS ob=NWS.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=NWS.class.getDeclaredMethod("getCertifiedWeatherData");
		m.setAccessible(true);
		String pageHeading=(String) m.invoke(ob);
		Assert.assertEquals(pageHeading, "Past Weather by Zip Code - Data Table");
		test.log(LogStatus.PASS, "Navigated to Certified Weather data page");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
