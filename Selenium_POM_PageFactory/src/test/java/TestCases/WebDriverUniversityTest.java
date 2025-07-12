package TestCases;
import java.lang.reflect.Method;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import Base.Baseclass;
import Pages.WebDriverUniversity;
import utilities.seleniumUtilities;

public class WebDriverUniversityTest extends Baseclass
{
	@Test
	void getTheListOfCoursesFromWebDriverUniversity() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://webdriveruniversity.com/index.html", driver);
		WebDriverUniversity ob=WebDriverUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=WebDriverUniversity.class.getDeclaredMethod("getTheListOfCourses");
		m.setAccessible(true);
		List<String> courseList=(List<String>) m.invoke(ob);
		Assert.assertEquals(courseList.get(3), "Playwright with Java");
		test.log(LogStatus.PASS, "List of courses displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
