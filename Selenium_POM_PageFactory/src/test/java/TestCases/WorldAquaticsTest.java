package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.WorldAquatics;
import utilities.seleniumUtilities;

public class WorldAquaticsTest extends Baseclass
{
	@Test
	void validateAquaSports() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.worldaquatics.com/", driver);
		WorldAquatics ob=WorldAquatics.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=WorldAquatics.class.getDeclaredMethod("getListOfSports");
		m.setAccessible(true);
		List<String> allAquaSports=(List<String>) m.invoke(ob);
		Assert.assertEquals(allAquaSports.get(3), "artistic-swimming");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
