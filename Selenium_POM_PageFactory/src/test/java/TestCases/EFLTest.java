package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.EFL;
import utilities.seleniumUtilities;

public class EFLTest extends Baseclass {
	
	
	
	@Test
	void getEFLCompetitionNames() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.efl.com/", driver);
		EFL ob=EFL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=EFL.class.getDeclaredMethod("getCompetitionNames");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
