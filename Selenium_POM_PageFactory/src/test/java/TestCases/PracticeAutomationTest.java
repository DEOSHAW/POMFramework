package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.PracticeAutomation;
import utilities.seleniumUtilities;

public class PracticeAutomationTest extends Baseclass
{
	@Test
	void validateLogin() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practicetestautomation.com/practice-test-login/", driver);
		PracticeAutomation ob=PracticeAutomation.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=PracticeAutomation.class.getDeclaredMethod("login", String.class, String.class);
		m.setAccessible(true);
		String successMessage=(String) m.invoke(ob, "student", "Password123");
		Assert.assertEquals(successMessage, "Logged In Successfully");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
