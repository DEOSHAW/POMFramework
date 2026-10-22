package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.EBC;
import utilities.seleniumUtilities;

public class EBCTest extends Baseclass
{
	@Test
	void validateHealthAccounts() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.ebcflex.com/", driver);
		EBC ob=EBC.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=EBC.class.getDeclaredMethod("getHealthAccounts");
		m.setAccessible(true);
		List<String> allAccounts=(List<String>) m.invoke(ob);
		Assert.assertEquals(allAccounts.get(3), "Commuter Benefits");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
