package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NUS;
import utilities.seleniumUtilities;

public class NUSTest extends Baseclass
{
	@Test
	void ValidateNUSFaculties() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://nus.edu.sg/", driver);
		NUS ob=NUS.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=NUS.class.getDeclaredMethod("getFaculties");
		m.setAccessible(true);
		List<String> nusSchools=(List<String>) m.invoke(ob);
		Assert.assertEquals(nusSchools.size(), 16);
		Assert.assertEquals(nusSchools.get(2), "Computing");
		test.log(LogStatus.PASS, "Assertions successful");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
