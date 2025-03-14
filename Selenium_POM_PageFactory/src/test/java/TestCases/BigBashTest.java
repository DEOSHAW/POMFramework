package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.BigBash;
import utilities.seleniumUtilities;

public class BigBashTest extends Baseclass
{
	@Test
	void HighlightBigBashTeamsLogo() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.bigbash.com.au/", driver);
		BigBash ob=BigBash.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=BigBash.class.getDeclaredMethod("HighlightAllTeamsLogo");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "All Teams' logos highlighted");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
