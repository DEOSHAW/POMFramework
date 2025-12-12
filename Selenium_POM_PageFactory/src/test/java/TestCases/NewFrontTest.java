package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NewFront;
import utilities.seleniumUtilities;

public class NewFrontTest extends Baseclass
{
	@Test
	void validateNavigationToLoginPage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.newfront.com/", driver);
		NewFront ob=NewFront.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=NewFront.class.getDeclaredMethod("navigateToLoginPage");
		m.setAccessible(true);
		String loginUrl=(String) m.invoke(ob);
		Assert.assertEquals(loginUrl, "https://app.newfront.com/login?returnUrl=%2F", "Url not found");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
