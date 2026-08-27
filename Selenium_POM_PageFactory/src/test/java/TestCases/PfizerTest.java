package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Pfizer;
import utilities.seleniumUtilities;

public class PfizerTest extends Baseclass
{
	@Test
	void validateMenuItems() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.pfizer.com/", driver);
		Pfizer ob=Pfizer.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Pfizer.class.getDeclaredMethod("getMenuItems");
		m.setAccessible(true);
		List<String> menuItems=(List<String>) m.invoke(ob);
		Assert.assertEquals(menuItems.get(3), "Newsroom");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
