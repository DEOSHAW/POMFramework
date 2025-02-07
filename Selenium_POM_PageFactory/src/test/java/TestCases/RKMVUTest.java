package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.RKMVU;
import utilities.seleniumUtilities;

public class RKMVUTest extends Baseclass
{
	@Test
	void getRKMVUSchools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://rkmvu.ac.in/", driver);
		RKMVU ob=RKMVU.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=RKMVU.class.getDeclaredMethod("getListOfSchools");
		m.setAccessible(true);
		List<String> schoolList=(List<String>) m.invoke(ob);
		System.out.println(schoolList);
		Assert.assertTrue(schoolList.get(1).contains("School of Mathematical Sciences"),"School name is not matching");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
