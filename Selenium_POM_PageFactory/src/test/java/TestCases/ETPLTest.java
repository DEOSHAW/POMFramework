package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ETPL;
import utilities.seleniumUtilities;

public class ETPLTest extends Baseclass
{
	@Test
	void validateETPLTeams() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.etplofficial.com/", driver);
		ETPL ob=ETPL.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ETPL.class.getDeclaredMethod("getTeams");
		m.setAccessible(true);
		List<String> etplTeams=(List<String>) m.invoke(ob);
		Assert.assertEquals(etplTeams.get(3), "DUBLIN GUARDIANS");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
