package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UPES;
import utilities.seleniumUtilities;

public class UPESTest extends Baseclass
{
	@Test
	void getUpesSchools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.upes.ac.in/", driver);
		UPES ob=UPES.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=UPES.class.getDeclaredMethod("getSchools");
		m.setAccessible(true);
		List<String> schoolList=(List<String>) m.invoke(ob);
		Assert.assertEquals(schoolList.get(3), "School of Design");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
