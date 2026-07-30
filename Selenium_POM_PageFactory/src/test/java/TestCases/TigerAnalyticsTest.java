package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TigerAnalytics;
import utilities.seleniumUtilities;

public class TigerAnalyticsTest extends Baseclass
{
	@Test
	void validateAboutUsPage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tigeranalytics.com/", driver);
		TigerAnalytics ob=TigerAnalytics.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TigerAnalytics.class.getDeclaredMethod("navigateToAboutUsPage");
		m.setAccessible(true);
		String aboutUsPageTitle=(String) m.invoke(ob);
		Assert.assertEquals(aboutUsPageTitle, "About Tiger Analytics – AI, Data, and Business Solutions");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
