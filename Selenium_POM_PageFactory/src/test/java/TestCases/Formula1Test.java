package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Formula1;
import utilities.seleniumUtilities;

public class Formula1Test extends Baseclass 
{
	@Test
	void getDriversStandingsInFormula1() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.formula1.com/", driver);
		Formula1 ob=Formula1.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Formula1.class.getDeclaredMethod("getDriversStandings");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Driver standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
