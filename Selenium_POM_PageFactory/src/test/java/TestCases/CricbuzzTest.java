package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Cricbuzz;
import utilities.seleniumUtilities;

public class CricbuzzTest extends Baseclass
{
	@Test
	void validateNavigationToMensRankings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.cricbuzz.com/", driver);
		Cricbuzz ob=Cricbuzz.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Cricbuzz.class.getDeclaredMethod("navigateToMensRankings");
		m.setAccessible(true);
		String pageHeader=(String) m.invoke(ob);
		Assert.assertEquals(pageHeader, "ICC men's Cricket Rankings");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
