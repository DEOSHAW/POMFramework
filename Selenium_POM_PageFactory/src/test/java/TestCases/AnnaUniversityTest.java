package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AnnaUniversity;
import utilities.seleniumUtilities;

public class AnnaUniversityTest extends Baseclass
{
	@Test
	void validateNavigationToAboutPage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.annauniv.edu/#gsc.tab=0", driver);
		AnnaUniversity ob=AnnaUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AnnaUniversity.class.getDeclaredMethod("navigateToAboutPage");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("Profile"),"Page title does not match");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
