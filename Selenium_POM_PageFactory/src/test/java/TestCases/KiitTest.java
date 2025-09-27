package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.KIIT;
import utilities.seleniumUtilities;

public class KiitTest extends Baseclass
{
	@Test
	void getListOfKiitSchools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://kiit.ac.in/", driver);
		KIIT ob=KIIT.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=KIIT.class.getDeclaredMethod("getListOfSchools");
		m.setAccessible(true);
		List<String> allSchools=(List<String>) m.invoke(ob);
		System.out.println(allSchools);
		Assert.assertEquals(allSchools.get(3), "School of Architecture & Planning");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
