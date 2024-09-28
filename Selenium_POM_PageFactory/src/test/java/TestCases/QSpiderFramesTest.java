package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.QSpiderFrames;
import utilities.seleniumUtilities;

public class QSpiderFramesTest extends Baseclass
{
	
	@Test
	void QSpiderFramesLoginTest() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demoapps.qspiders.com/ui/frames?sublist=0", driver);
		QSpiderFrames ob=QSpiderFrames.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=QSpiderFrames.class.getDeclaredMethod("Login");
		m.setAccessible(true);
		String successMessage=(String) m.invoke(ob);
		Assert.assertEquals(successMessage, "Login successful!");
		test.log(LogStatus.PASS, "Login successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
