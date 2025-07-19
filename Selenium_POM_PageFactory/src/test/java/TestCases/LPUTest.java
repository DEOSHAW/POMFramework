package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.LPU;
import utilities.seleniumUtilities;

public class LPUTest extends Baseclass
{
	@Test
	void getTheListOfCoursesInLPU() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.lpu.in/", driver);
		LPU ob=LPU.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=LPU.class.getDeclaredMethod("getTheListOfCourses");
		m.setAccessible(true);
		List<String> courses=(List<String>) m.invoke(ob);
		System.out.println(courses);
		Assert.assertEquals(courses.get(3), "ELECTRONICS & ELECTRICAL ENGINEERING");
		test.log(LogStatus.PASS, "List of courses displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
