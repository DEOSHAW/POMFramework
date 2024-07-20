package TestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SPJain;
import utilities.seleniumUtilities;

public class SPJainTest extends Baseclass
{
	@Test
	void getSPJainPrograms()throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.spjimr.org/", driver);
		Constructor constructor=SPJain.class.getDeclaredConstructor(WebDriver.class);
		constructor.setAccessible(true);
		SPJain ob=(SPJain) constructor.newInstance(driver);
		Method m=SPJain.class.getDeclaredMethod("getPrograms");
		m.setAccessible(true);
		List<String> allPrograms=(List<String>) m.invoke(ob);
		Assert.assertEquals(allPrograms.get(3), "Global Management Programme (GMP)");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
