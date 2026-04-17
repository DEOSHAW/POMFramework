package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SymbiosisUniversity;
import utilities.seleniumUtilities;

public class SymbiosisUniversityTest extends Baseclass
{
	@Test
	void validateProgrammeLevels() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.siu.edu.in/", driver);
		SymbiosisUniversity ob=SymbiosisUniversity.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SymbiosisUniversity.class.getDeclaredMethod("getProgrammeLevels");
		m.setAccessible(true);
		List<String> allProgrammeLevels=(List<String>) m.invoke(ob);
		System.out.println(allProgrammeLevels);
		Assert.assertEquals(allProgrammeLevels.get(3), "Certificate Programme");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
