package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TAPMI;
import utilities.seleniumUtilities;

public class TAPMITest extends Baseclass
{
	@Test
	void validateMbaPrograms() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tapmi.edu.in/", driver);
		TAPMI ob=TAPMI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TAPMI.class.getDeclaredMethod("getMbaPrograms");
		m.setAccessible(true);
		List<String> programList=(List<String>) m.invoke(ob);
		System.out.println(programList);
		Assert.assertEquals(programList.get(3), "MBA-Marketing");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
