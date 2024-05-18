package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UCBerkeley;
import utilities.seleniumUtilities;

public class UCBerkeleyTest extends Baseclass
{
	
	@Test
	void getUCBerkeleyResearchUnits() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.berkeley.edu/", driver);
		UCBerkeley ob=UCBerkeley.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=UCBerkeley.class.getDeclaredMethod("getResearchUnits");
		m.setAccessible(true);
		List<String> allResearchUnits=(List<String>) m.invoke(ob);
		test.log(LogStatus.PASS, "List of Research units displayed");
		Assert.assertEquals(allResearchUnits.get(3), "Berkeley Center for Cosmological Physics");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
