package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.KCL;
import utilities.seleniumUtilities;

public class KclTest extends Baseclass
{
	@Test
	void ValidateTeamsOfKcl() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://kabaddichampionsleague.com/", driver);
		KCL ob=KCL.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=KCL.class.getDeclaredMethod("getTeams");
		m.setAccessible(true);
		List<String> allTeams=(List<String>) m.invoke(ob);
		System.out.println(allTeams);
		Assert.assertEquals(allTeams.get(3), "Gurugram Gurus");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
