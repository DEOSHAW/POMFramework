package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AsianGames2026;
import utilities.seleniumUtilities;

public class AsianGames2026Test extends Baseclass
{
	@Test
	void validateAsianGamesMedalsTally() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://olympic.ind.in/asian-games-2026/", driver);
		AsianGames2026 ob=AsianGames2026.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AsianGames2026.class.getDeclaredMethod("getTopCountriesInMedalsTally");
		m.setAccessible(true);
		List<String> topCountries=(List<String>) m.invoke(ob);
		Assert.assertEquals(topCountries.get(3), "Uzbekistan");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
