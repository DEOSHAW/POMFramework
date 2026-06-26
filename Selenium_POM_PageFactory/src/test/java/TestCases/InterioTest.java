package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Interio;
import utilities.seleniumUtilities;

public class InterioTest extends Baseclass
{
	@Test
	void validateMenuOptions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://interio.com/", driver);
		Interio ob=Interio.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Interio.class.getDeclaredMethod("getAllMenuOptions");
		m.setAccessible(true);
		List<String> allMenuOptions=(List<String>) m.invoke(ob);
		System.out.println(allMenuOptions);
		Assert.assertEquals(allMenuOptions.get(3), "Office and Study");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");	
	}
}
