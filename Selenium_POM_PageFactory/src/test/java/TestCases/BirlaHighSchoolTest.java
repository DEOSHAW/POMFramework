package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.BirlaHighSchool;
import utilities.seleniumUtilities;

public class BirlaHighSchoolTest extends Baseclass
{
	@Test
	void ValidateAboutSchoolText() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://birlahighschool.com/", driver);
		BirlaHighSchool ob=BirlaHighSchool.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=BirlaHighSchool.class.getDeclaredMethod("getAboutSchoolTest");
		m.setAccessible(true);
		String schoolText=(String) m.invoke(ob);
		System.out.println(schoolText);
		Assert.assertTrue(schoolText.contains("Birla High School-Mukundapur"));
		test.log(LogStatus.PASS, "School about text assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
