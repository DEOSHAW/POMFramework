package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.CoventryUniversity;
import utilities.seleniumUtilities;

public class CoventryUniversityTest extends Baseclass
{
	@Test
	void getCoventryInternationalUniversityText() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.coventry.ac.uk/", driver);
		CoventryUniversity ob=CoventryUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=CoventryUniversity.class.getDeclaredMethod("getInternationalUniversityText");
		m.setAccessible(true);
		String text=(String) m.invoke(ob);
		System.out.println(text);
		Assert.assertTrue(text.contains("we have welcomed students from over 150 countries"));
		test.log(LogStatus.PASS, "Assertion passed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
