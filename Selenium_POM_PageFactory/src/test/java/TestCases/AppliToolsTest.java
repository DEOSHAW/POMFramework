package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AppliTools;
import utilities.seleniumUtilities;

public class AppliToolsTest extends Baseclass
{
	
	@Test
	void DisplayBrandsUsingAppliTools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://applitools.com/", driver);
		AppliTools ob=AppliTools.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AppliTools.class.getDeclaredMethod("showBrands");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Brands displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
