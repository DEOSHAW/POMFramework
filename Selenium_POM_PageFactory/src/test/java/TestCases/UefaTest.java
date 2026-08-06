package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Uefa;
import utilities.seleniumUtilities;

public class UefaTest extends Baseclass
{
	@Test
	void validateUefaMenClubCompetitions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.uefa.com/", driver);
		Uefa ob=Uefa.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Uefa.class.getDeclaredMethod("getMensClubCompetitions");
		m.setAccessible(true);
		List<String> menClubCompetitionList=(List<String>) m.invoke(ob);
		Assert.assertEquals(menClubCompetitionList.size(), 6);
		Assert.assertEquals(menClubCompetitionList.get(3), "UEFA Super Cup");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
