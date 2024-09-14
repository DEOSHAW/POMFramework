package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.PLL;
import utilities.seleniumUtilities;

public class PLLTest extends Baseclass
{
	@Test
	void getPLLStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://premierlacrosseleague.com/", driver);
		PLL ob=PLL.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=PLL.class.getDeclaredMethod("getOverallStandings");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Teams' standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
