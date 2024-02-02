package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Boeing;
import utilities.seleniumUtilities;

public class BoeingTest extends Baseclass
{
	@Test
	void getBoeingCommercialServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.boeing.com/", driver);
		Boeing ob=Boeing.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Boeing.class.getDeclaredMethod("getCommercialServices");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "List of Commercial Services displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
