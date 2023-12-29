package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NalandaUniversity;
import utilities.seleniumUtilities;

public class NalandaUniversityTest extends Baseclass
{
	
	@Test
	void getSchoolNamesUnderNalandaUniversity() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://nalandauniv.edu.in/", driver);
		NalandaUniversity ob=NalandaUniversity.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NalandaUniversity.class.getDeclaredMethod("getSchoolNames");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "List of Schools displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
