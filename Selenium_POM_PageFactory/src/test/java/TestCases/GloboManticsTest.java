package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Globomantics;
import utilities.seleniumUtilities;

public class GloboManticsTest extends Baseclass
{
	@Test
	void getThemesOnGloboManticsPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.pluralsight.com/teach/author-tools/globomantics/index", driver);
		Globomantics ob=Globomantics.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Globomantics.class.getDeclaredMethod("getThemesOnGloboManticsPortal");
		m.setAccessible(true);
		List<String> allThemes=(List<String>) m.invoke(ob);
		System.out.println(allThemes);
		Assert.assertEquals(allThemes.get(1), "ROBOTICS");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
