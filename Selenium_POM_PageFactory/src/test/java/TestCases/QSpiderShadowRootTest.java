package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.QSpiderShadowRoot;
import utilities.seleniumUtilities;

public class QSpiderShadowRootTest extends Baseclass
{
	@Test
	void loginToQspider() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demoapps.qspiders.com/ui/shadow", driver);
		QSpiderShadowRoot ob=QSpiderShadowRoot.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=QSpiderShadowRoot.class.getDeclaredMethod("login");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Login successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
