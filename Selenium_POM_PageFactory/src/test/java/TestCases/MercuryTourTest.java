package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.MercuryTour;
import utilities.seleniumUtilities;

public class MercuryTourTest extends Baseclass
{
	
	@Test
	void loginTest() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demo.guru99.com/test/newtours/", driver);
		MercuryTour ob=MercuryTour.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=MercuryTour.class.getDeclaredMethod("login",String.class,String.class);
		m.setAccessible(true);
		String successMsg=(String) m.invoke(ob,seleniumUtilities.getDataForKey("MERCURY_USER"),seleniumUtilities.getDataForKey("MERCURY_PASSWORD"));
		Assert.assertEquals(successMsg, "Login Successfully");
		test.log(LogStatus.PASS, "Logged in successfully");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
