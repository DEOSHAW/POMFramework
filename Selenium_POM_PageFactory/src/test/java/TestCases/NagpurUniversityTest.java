package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NagpurUniversity;
import utilities.seleniumUtilities;

public class NagpurUniversityTest extends Baseclass
{
	@Test
	void validateDepartments() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://nagpuruniversity.ac.in/", driver);
		NagpurUniversity ob=NagpurUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=NagpurUniversity.class.getDeclaredMethod("getDepartments");
		m.setAccessible(true);
		List<String> departmentList=(List<String>) m.invoke(ob);
		Assert.assertTrue(departmentList.get(3).contains("Faculty of Interdisciplinary Studies"),"Department did not match!");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
