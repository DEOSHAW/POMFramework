package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationWindowsDemo;
import utilities.seleniumUtilities;

public class AutomationWindowsDemoTest extends Baseclass
{

	@Test
	void testWindowSwitching() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demo.automationtesting.in/Windows.html", driver);
		AutomationWindowsDemo ob=AutomationWindowsDemo.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationWindowsDemo.class.getDeclaredMethod("getPageTitleOfNewWindow");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		Assert.assertEquals(pageTitle, "Selenium");
		test.log(LogStatus.PASS, "Asserted page title of new window");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
