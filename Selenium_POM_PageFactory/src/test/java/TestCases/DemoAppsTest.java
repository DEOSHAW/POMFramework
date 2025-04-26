package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.DemoApps;
import utilities.seleniumUtilities;

public class DemoAppsTest extends Baseclass
{
	@Test
	void enterLoginCredentialsOnDemoApp() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demoapps.qspiders.com/ui/shadow?sublist=0", driver);
		DemoApps ob=DemoApps.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=DemoApps.class.getDeclaredMethod("enterLoginCredentials");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Login Credentials Entered");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
