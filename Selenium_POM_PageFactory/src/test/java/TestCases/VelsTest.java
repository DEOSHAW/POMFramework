package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Vels;
import utilities.seleniumUtilities;

public class VelsTest extends Baseclass
{
	@Test
	void getVelsPrograms() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://vistas.ac.in/", driver);
		Vels ob=Vels.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Vels.class.getDeclaredMethod("getPrograms");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "All programs displayed");
		test.log(LogStatus.PASS, "Test Ended");	
	}

}
