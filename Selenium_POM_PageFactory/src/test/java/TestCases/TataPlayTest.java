package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TataPlay;
import utilities.seleniumUtilities;

public class TataPlayTest extends Baseclass
{
	@Test
	void GetImportantLinksOnTataPlayPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tataplay.com/", driver);
		TataPlay ob=TataPlay.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TataPlay.class.getDeclaredMethod("GetImportantLinks");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "All important Links displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
