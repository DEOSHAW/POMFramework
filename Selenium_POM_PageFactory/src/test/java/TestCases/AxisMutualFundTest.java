package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AxisMutualFund;
import utilities.seleniumUtilities;

public class AxisMutualFundTest extends Baseclass
{
	@Test
	void NavigateToStartASipSectionOnAxisMfPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.axismf.com/", driver);
		AxisMutualFund ob=AxisMutualFund.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AxisMutualFund.class.getDeclaredMethod("NavigateToStartASipSection");
		m.setAccessible(true);
		String headerText=(String) m.invoke(ob);
		Assert.assertEquals(headerText, "Make small investments for bigger returns");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
