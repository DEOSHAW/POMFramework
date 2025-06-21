package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuAppWindow;
import utilities.seleniumUtilities;

public class HerokuAppWindowTest extends Baseclass
{
	
	@Test
	void validateSwitchingToNewWindow() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/windows", driver);
		HerokuAppWindow ob=HerokuAppWindow.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuAppWindow.class.getDeclaredMethod("switchToNewWindow");
		m.setAccessible(true);
		String newWindowHeading=(String) m.invoke(ob);
		Assert.assertEquals(newWindowHeading, "New Window");
		test.log(LogStatus.PASS, "Switched to new window");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
