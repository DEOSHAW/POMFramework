package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FIFA;
import utilities.seleniumUtilities;

public class FifaTest extends Baseclass
{
	@Test
	void getTopFiveInFifaRankings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.fifa.com/en", driver);
		FIFA ob=FIFA.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FIFA.class.getDeclaredMethod("getTopFiveInRankings");
		m.setAccessible(true);
		List<String> fifaRankings=(List<String>) m.invoke(ob);
		Assert.assertEquals(fifaRankings.get(0), "Spain");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
