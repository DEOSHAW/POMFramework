package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AshokaUniversity;
import utilities.seleniumUtilities;

public class AshokaUniversityTest extends Baseclass
{
	@Test
	void validateDepartments() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.ashoka.edu.in/", driver);
		AshokaUniversity ob=AshokaUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AshokaUniversity.class.getDeclaredMethod("getDepartments");
		m.setAccessible(true);
		List<String> departments=(List<String>) m.invoke(ob);
		System.out.println(departments);
		Assert.assertEquals(departments.get(3), "Performing Arts");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
