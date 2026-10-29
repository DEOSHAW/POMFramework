package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FTTI;
import utilities.seleniumUtilities;

public class FTTITest extends Baseclass
{
	@Test
	void validateSections() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://ftii.ac.in/", driver);
		FTTI ob=FTTI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FTTI.class.getDeclaredMethod("getSections");
		m.setAccessible(true);
		List<String> sections=(List<String>) m.invoke(ob);
		System.out.println(sections);
		Assert.assertEquals(sections.get(3), "Multimedia");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
