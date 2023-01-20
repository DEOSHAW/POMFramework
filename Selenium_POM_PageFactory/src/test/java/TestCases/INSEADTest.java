package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.INSEAD;
import utilities.seleniumUtilities;

public class INSEADTest extends Baseclass {
	
	
	
	@Test
	void getINSEADMastersProgrammes() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.insead.edu/", driver);
		INSEAD ob=INSEAD.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=INSEAD.class.getDeclaredMethod("getMastersProgramme");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
