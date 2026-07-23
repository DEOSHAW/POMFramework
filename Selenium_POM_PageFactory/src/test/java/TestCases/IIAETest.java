package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IIAE;
import utilities.seleniumUtilities;

public class IIAETest extends Baseclass
{
	
	@Test
	void validateOfferedCourses() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://iiaepune.org/", driver);
		IIAE ob=IIAE.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IIAE.class.getDeclaredMethod("getOfferedCourses");
		m.setAccessible(true);
		List<String> coursesList=(List<String>) m.invoke(ob);
		Assert.assertEquals(coursesList.get(3), "4. Commercial Pilot License (CPL) - At Avation Junction Flying School( South Africa) and Delta Qualiflight (USA)", "Course name did not match !");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
