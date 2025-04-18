package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SeleniumBaseIoHover;
import utilities.seleniumUtilities;

public class SeleniumBaseIoHoverTest extends Baseclass
{
	@Test
	void getgetMenuOptionsOnHover() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page", driver);
		SeleniumBaseIoHover ob=SeleniumBaseIoHover.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SeleniumBaseIoHover.class.getDeclaredMethod("getMenuOptions");
		m.setAccessible(true);
		List<String> menuOptions=(List<String>) m.invoke(ob);
		Assert.assertEquals(menuOptions.get(2), "Link Three");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
