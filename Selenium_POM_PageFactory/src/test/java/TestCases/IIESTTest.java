package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IIEST;
import utilities.seleniumUtilities;

public class IIESTTest extends Baseclass
{
	@Test
	void validateMissionAndVision() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.iiests.ac.in/en", driver);
		IIEST ob=IIEST.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IIEST.class.getDeclaredMethod("getMissionAndVision");
		m.setAccessible(true);
		String mission=(String) m.invoke(ob);
		String expectedText="ranks 27th in NIRF-2021 among Engineering Institutes";
		Assert.assertTrue(mission.contains(expectedText),"Mission text is not matching");
		test.log(LogStatus.PASS, "Test Ended");
		test.log(LogStatus.PASS, "Validation successful");
	}
}
