package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.OpJindal;
import utilities.seleniumUtilities;

public class OpJindalTest extends Baseclass
{
	@Test
	void getOPJindalGlobalSchoolsList() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://jgu.edu.in/", driver);
		OpJindal ob=OpJindal.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=OpJindal.class.getDeclaredMethod("getListOfSchools");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "List of schools displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
