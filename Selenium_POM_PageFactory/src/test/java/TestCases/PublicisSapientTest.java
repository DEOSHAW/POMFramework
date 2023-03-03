package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PublicisSapient;
import utilities.seleniumUtilities;

public class PublicisSapientTest extends Baseclass 
{
	
	
	
	@Test
	void getPublicisSapientServices() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.publicissapient.com/", driver);
		PublicisSapient ob=PublicisSapient.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=PublicisSapient.class.getDeclaredMethod("getListOfServices");
		m.setAccessible(true);
		m.invoke(ob);
		
	}
	
	
	

}
