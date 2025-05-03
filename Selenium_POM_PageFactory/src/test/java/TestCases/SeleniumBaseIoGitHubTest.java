package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SeleniumBaseIoGitHub;
import utilities.seleniumUtilities;

public class SeleniumBaseIoGitHubTest extends Baseclass
{
	
	@Test
	void navigateToSeleniumBaseIoGitHubProject() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page", driver);
		test.log(LogStatus.PASS, "Test Started");
		SeleniumBaseIoGitHub ob=SeleniumBaseIoGitHub.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SeleniumBaseIoGitHub.class.getDeclaredMethod("navigateToGitHubRepository");
		m.setAccessible(true);
		String githubUrl=(String) m.invoke(ob, null);
		System.out.println(githubUrl);
		Assert.assertEquals(githubUrl, "https://github.com/seleniumbase/SeleniumBase");
		test.log(LogStatus.PASS, "Navigated to Github project");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
