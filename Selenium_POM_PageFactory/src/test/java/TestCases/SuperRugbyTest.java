package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SuperRugby;
import utilities.seleniumUtilities;

public class SuperRugbyTest extends Baseclass
{
	@Test
	void displaySuperRugbyPacificStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://super.rugby/superrugby/", driver);
		SuperRugby ob=SuperRugby.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SuperRugby.class.getDeclaredMethod("displayLeagueStandings");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "League Standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
