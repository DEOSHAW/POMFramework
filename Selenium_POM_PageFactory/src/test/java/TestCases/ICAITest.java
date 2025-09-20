package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ICAI;
import utilities.seleniumUtilities;

public class ICAITest extends Baseclass
{
	@Test
	void navigateToIcaiNowPageOnIcaiPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.icai.org/", driver);
		ICAI ob=ICAI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ICAI.class.getDeclaredMethod("navigateToIcaiNowPage");
		m.setAccessible(true);
		String icaiPageUrl=(String) m.invoke(ob);
		System.out.println("**********"+icaiPageUrl+"********");
		Assert.assertEquals(icaiPageUrl, "https://mobile.icai.org/");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
