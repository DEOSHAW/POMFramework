package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Telus;
import utilities.seleniumUtilities;

public class TelusTest extends Baseclass
{
	
	@Test
	void getIndustriesServedByTelus() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.telusinternational.com/", driver);
		Telus ob=Telus.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Telus.class.getDeclaredMethod("getIndustriesServed");
		m.setAccessible(true);
		List<String> industriesServed=(List<String>) m.invoke(ob);
		Assert.assertEquals(industriesServed.get(6), "Healthcare");
		test.log(LogStatus.PASS, "Assertion for Healthcare passed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
