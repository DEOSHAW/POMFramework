package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AIT;
import utilities.seleniumUtilities;

public class AitTest extends Baseclass
{
	@Test
	void ValidateMenuOptions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.aitpune.com/", driver);
		AIT ob=AIT.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AIT.class.getDeclaredMethod("getMenuOptions");
		m.setAccessible(true);
		List<String> allMenu=(List<String>) m.invoke(ob);
		System.out.println(allMenu);
		Assert.assertEquals(allMenu.get(3), "Programmes");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
