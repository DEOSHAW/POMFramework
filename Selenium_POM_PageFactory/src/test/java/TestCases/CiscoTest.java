package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Cisco;
import utilities.seleniumUtilities;

public class CiscoTest extends Baseclass
{
	@Test
	void navigateToCiscoSiteMap() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.cisco.com/site/in/en/index.html", driver);
		Cisco ob=Cisco.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Cisco.class.getDeclaredMethod("navigateToSiteMap");
		m.setAccessible(true);
		String headingText=(String) m.invoke(ob);
		Assert.assertEquals(headingText, "Explore Cisco");
		test.log(LogStatus.PASS, "Navigated to site map");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
