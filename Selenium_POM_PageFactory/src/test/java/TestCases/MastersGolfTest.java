package TestCases;

import java.lang.reflect.Method;
import java.time.Year;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.MastersGolf;
import utilities.seleniumUtilities;

public class MastersGolfTest extends Baseclass 
{
	@Test
	void validateMastersGolfPageTitle() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.masters.com/index.html", driver);
		MastersGolf ob=MastersGolf.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=MastersGolf.class.getDeclaredMethod("getMastersPageTitle");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		System.out.println("Page title is: "+pageTitle);
		Assert.assertTrue(pageTitle.contains("Masters at Augusta National"));
		test.log(LogStatus.PASS, "Page title validated successfully");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
