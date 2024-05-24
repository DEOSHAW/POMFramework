package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IndyCar;
import utilities.seleniumUtilities;

public class IndyCarTest extends Baseclass
{
	@Test
	void getIndyCarDriversStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.indycar.com/", driver);
		IndyCar ob=IndyCar.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IndyCar.class.getDeclaredMethod("getDriversStandings");
		m.setAccessible(true);
		List<String> driversList=(List<String>) m.invoke(ob);
		System.out.println(driversList);
		Assert.assertEquals(driversList.get(2), "Scott  Dixon");
		Assert.assertTrue(driversList.contains("Scott  McLaughlin"));
		test.log(LogStatus.PASS, "Assertions successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
