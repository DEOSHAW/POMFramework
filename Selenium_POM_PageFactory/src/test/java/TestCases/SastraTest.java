package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Sastra;
import utilities.seleniumUtilities;

public class SastraTest extends Baseclass
{
	@Test
	void getListOfSastraSchools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.sastra.edu/", driver);
		Sastra ob=Sastra.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Sastra.class.getDeclaredMethod("getTheListOfSchools");
		m.setAccessible(true);
		List<String> schools=(List<String>) m.invoke(ob);
		Assert.assertEquals(schools.get(3), "School of Electrical & Electronics Engineering");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
