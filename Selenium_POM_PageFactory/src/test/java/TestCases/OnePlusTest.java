package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.OnePlus;
import utilities.seleniumUtilities;

public class OnePlusTest extends Baseclass
{
	@Test
	void validateNavigationToStore() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.LaunchBrowser("https://www.oneplus.in/", driver);
		OnePlus ob=OnePlus.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=OnePlus.class.getDeclaredMethod("navigateToStore");
		m.setAccessible(true);
		String storeUrl=(String) m.invoke(ob);
		Assert.assertTrue(storeUrl.contains("store"));
		test.log(LogStatus.PASS, "Validation successful");
	    test.log(LogStatus.PASS, "Test Ended");
	}
}
