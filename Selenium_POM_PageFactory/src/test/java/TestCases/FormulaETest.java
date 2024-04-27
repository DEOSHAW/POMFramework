package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FormulaE;
import utilities.seleniumUtilities;

public class FormulaETest extends Baseclass
{
	
	@Test
	void getFormulaEDriverStandings() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.fiaformulae.com/en", driver);
		FormulaE Fe=FormulaE.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FormulaE.class.getDeclaredMethod("getDriverStanding");
		m.setAccessible(true);
		m.invoke(Fe);
		test.log(LogStatus.PASS, "Drivers' standings displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
