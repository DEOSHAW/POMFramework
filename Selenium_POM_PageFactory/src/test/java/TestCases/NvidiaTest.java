package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Nvidia;
import utilities.seleniumUtilities;

public class NvidiaTest extends Baseclass
{
	
	
	@Test
	void GetNvidiaApplicationFrameworks() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.nvidia.com/en-in/", driver);
		Nvidia ob=Nvidia.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Nvidia.class.getDeclaredMethod("getApplicationFrameworks");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Application frameworks highlighted");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
