package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.VIT;
import utilities.seleniumUtilities;

public class VitTest extends Baseclass
{
	@Test
	void getVitImage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://vit.ac.in/", driver);
		VIT ob=VIT.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=VIT.class.getDeclaredMethod("getUniversityImage");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Institute image captured");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
