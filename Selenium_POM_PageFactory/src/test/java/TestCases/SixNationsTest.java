package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SixNations;
import utilities.seleniumUtilities;

public class SixNationsTest extends Baseclass
{
	@Test
	void GetSixNationsMenStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.sixnationsrugby.com/en", driver);
		SixNations ob=SixNations.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SixNations.class.getDeclaredMethod("GetMenStandings");
		m.setAccessible(true);
		m.invoke(ob);	
		test.log(LogStatus.PASS, "Six Nations Men Standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
