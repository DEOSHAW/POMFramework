package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NextGenAiMultipleWindows;
import utilities.seleniumUtilities;

public class NextGenAiMultipleWindowsTest extends Baseclass
{
	
	
	@Test
	void multipleWindowTest() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://nxtgenaiacademy.com/multiplewindows/", driver);
		NextGenAiMultipleWindows ob=NextGenAiMultipleWindows.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NextGenAiMultipleWindows.class.getDeclaredMethod("multipleWindowSwitchingDemo");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		
		if(pageTitle.contains("NxtGen A.I Academy – Automate Intelligently"))
		{
			test.log(LogStatus.PASS, "Page title validation passed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
		Assert.assertEquals(pageTitle, "NxtGen A.I Academy – Automate Intelligently","Page title does not match");
		
		
		
	}

}
