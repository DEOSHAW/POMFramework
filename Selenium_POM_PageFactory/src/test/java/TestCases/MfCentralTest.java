package TestCases;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.MfCentral;
import utilities.seleniumUtilities;

public class MfCentralTest extends Baseclass
{
	@Test
	void getQuickLinsFromMfCentral() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.mfcentral.com/", driver);
		MfCentral ob=MfCentral.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=MfCentral.class.getDeclaredMethod("getQuickLinks");
		m.setAccessible(true);
		List<String> quickLinks=(List<String>) m.invoke(ob);
		System.out.println(quickLinks);
		Assert.assertEquals(quickLinks.get(3), "Transfer of units");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
