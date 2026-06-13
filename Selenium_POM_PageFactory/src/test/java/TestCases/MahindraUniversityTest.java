package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.MahindraUniversity;
import utilities.seleniumUtilities;

public class MahindraUniversityTest extends Baseclass
{
	@Test
	void validateSchool() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.mahindrauniversity.edu.in/", driver);
		MahindraUniversity ob=MahindraUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=MahindraUniversity.class.getDeclaredMethod("getAllSchools");
		m.setAccessible(true);
		List<String> schools=(List<String>) m.invoke(ob);
		Assert.assertEquals(schools.get(3), "School of Digital Media and Communication");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
