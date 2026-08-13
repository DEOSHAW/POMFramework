package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SelectorsHub;
import utilities.seleniumUtilities;

public class SelectorsHubTest extends Baseclass
{
	@Test
	void validateShadowDom() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://selectorshub.com/iframe-in-shadow-dom/", driver);
		SelectorsHub ob=SelectorsHub.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SelectorsHub.class.getDeclaredMethod("typeInsideShadowDom");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Test Ended");
	}
}
