package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Cyient;
import utilities.seleniumUtilities;

public class CyientTest extends Baseclass{
	
	
	@Test
	void getCyientInformation() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.cyient.com/", driver);
		Cyient ob=Cyient.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Cyient.class.getDeclaredMethod("getCompanyInformation");
		//m.setAccessible(true);
		m.invoke(ob);
	}

}
