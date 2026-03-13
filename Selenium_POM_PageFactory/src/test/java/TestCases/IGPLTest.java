package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IGPL;
import utilities.seleniumUtilities;

public class IGPLTest extends Baseclass
{
	@Test
	void validateIGPLTeams() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.LaunchBrowser("https://theigpl.com/", driver);
		IGPL ob=IGPL.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IGPL.class.getDeclaredMethod("getIGPLTeams");
		m.setAccessible(true);
		List<String> allTeams=(List<String>) m.invoke(ob);
		Assert.assertEquals(allTeams.get(3), "Delhi");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
