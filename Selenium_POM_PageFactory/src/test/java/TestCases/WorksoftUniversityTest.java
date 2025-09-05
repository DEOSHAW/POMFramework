package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.WorksoftUniversity;
import utilities.seleniumUtilities;

public class WorksoftUniversityTest extends Baseclass
{
	@Test
	void getWorksoftCourses() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.worksoft.com/worksoft-university/", driver);
		WorksoftUniversity ob=WorksoftUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=WorksoftUniversity.class.getDeclaredMethod("getCourses");
		m.setAccessible(true);
		List<String> worksoftCourses=(List<String>) m.invoke(ob);
		System.out.println(worksoftCourses);
		Assert.assertEquals(worksoftCourses.get(3), "Worksoft Advanced Web / HTML");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");		
	}

}
