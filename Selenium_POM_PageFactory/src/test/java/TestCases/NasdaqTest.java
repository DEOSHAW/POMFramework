package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Nasdaq;
import utilities.seleniumUtilities;

public class NasdaqTest extends Baseclass
{
	
	@Test
	void navigateToNasdaqCareersPage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.nasdaq.com/", driver);
		Nasdaq ob=Nasdaq.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Nasdaq.class.getDeclaredMethod("navigateToCareersPage");
		m.setAccessible(true);
		String actualPageTitle=(String) m.invoke(ob);
		Assert.assertEquals(actualPageTitle, "Careers | Nasdaq");
		test.log(LogStatus.PASS, "Navigated to Nasdaq Careers page");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
