package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Mockoon;
import utilities.seleniumUtilities;

public class MockoonTest extends Baseclass
{
	@Test
	void validateSolutions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://mockoon.com/", driver);
		Mockoon ob=Mockoon.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Mockoon.class.getDeclaredMethod("getSolutions");
		m.setAccessible(true);
		List<String> solutionList=(List<String>) m.invoke(ob);
		Assert.assertEquals(solutionList.get(1), "API Virtualization");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
