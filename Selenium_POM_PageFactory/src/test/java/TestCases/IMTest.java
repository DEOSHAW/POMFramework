package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IM;
import utilities.seleniumUtilities;

public class IMTest extends Baseclass
{
	@Test
	void navigateToShopForIMPlans() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://my.viabenefits.com/",driver);
		IM ob=IM.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IM.class.getDeclaredMethod("navigateToShopForPlans");
		m.setAccessible(true);
		String headerText=(String) m.invoke(ob);
		Assert.assertEquals(headerText, "Prepare To Shop");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
