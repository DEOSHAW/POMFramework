package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuRedirection;
import utilities.seleniumUtilities;

public class HerokuRedirectionTest extends Baseclass
{
	@Test
	void validateRedirectionOnHerokuPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/redirector", driver);
		HerokuRedirection ob=HerokuRedirection.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuRedirection.class.getDeclaredMethod("getRedirectedPageUrl");
		m.setAccessible(true);
		String redirectedPageUrl=(String) m.invoke(ob);
		Assert.assertTrue(redirectedPageUrl.contains("/status_codes"), "Not redirected to correct page");
		test.log(LogStatus.PASS, "Redirected to correct status code page");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
