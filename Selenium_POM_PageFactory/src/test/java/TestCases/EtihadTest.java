package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Etihad;
import utilities.seleniumUtilities;

public class EtihadTest extends Baseclass
{
	
	@Test
	void searchFlightOnEtihad() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.etihad.com/en-in/", driver);
		Etihad ob=Etihad.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Etihad.class.getDeclaredMethod("searchFlight",String.class,String.class);
		m.setAccessible(true);
		m.invoke(ob,seleniumUtilities.getDataForKey("ORIGIN"),seleniumUtilities.getDataForKey("DESTINATION"));
		test.log(LogStatus.PASS, "All available flights displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
