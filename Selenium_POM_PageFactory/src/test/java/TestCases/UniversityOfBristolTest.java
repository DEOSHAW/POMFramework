package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UniversityOfBristol;
import utilities.seleniumUtilities;

public class UniversityOfBristolTest extends Baseclass
{
	@Test
	void validateCourseSearch() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.bristol.ac.uk/", driver);
		UniversityOfBristol ob=UniversityOfBristol.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=UniversityOfBristol.class.getDeclaredMethod("navigateToCourseSearchResultPage");
		m.setAccessible(true);
		String resultPageHeader=(String) m.invoke(ob);
		Assert.assertTrue(resultPageHeader.contains("results found"),"Page Header is not matching");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
