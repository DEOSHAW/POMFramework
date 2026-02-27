package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SNU;
import utilities.seleniumUtilities;

public class SnuTest extends Baseclass
{
	@Test
	void searchForMenuOptionOnSnuPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.snuniv.ac.in/", driver);
		SNU ob=SNU.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SNU.class.getDeclaredMethod("searchForMenuOption");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Test successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
