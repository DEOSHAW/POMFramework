package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NIRF;
import utilities.seleniumUtilities;

public class NIRFTest extends Baseclass
{
	@Test
	void validateNIRFRankings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.nirfindia.org/Home/Index", driver);
		NIRF ob=NIRF.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=NIRF.class.getDeclaredMethod("getUniversityRankings");
		m.setAccessible(true);
		List<String> rankingList=(List<String>) m.invoke(ob);
		Assert.assertTrue(rankingList.get(4).contains("University of Delhi"),"University name did not match!");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");	
	}

}
