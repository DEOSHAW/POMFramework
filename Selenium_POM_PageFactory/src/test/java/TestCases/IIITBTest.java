package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IIITB;
import utilities.seleniumUtilities;

public class IIITBTest extends Baseclass
{
	@Test
	void validatePrograms() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.iiitb.ac.in/", driver);
		IIITB ob=IIITB.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IIITB.class.getDeclaredMethod("getPrograms");
		m.setAccessible(true);
		m.invoke(ob);
		List<String> allPrograms=(List<String>)m.invoke(ob);
		Assert.assertEquals(allPrograms.get(3), "Master of Science by Research");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
