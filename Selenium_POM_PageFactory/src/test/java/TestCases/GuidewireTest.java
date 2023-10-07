package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Guidewire;
import utilities.seleniumUtilities;

public class GuidewireTest extends Baseclass 
{
	
	
	@Test
	void listGuidewireProducts() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.guidewire.com/", driver);
		Guidewire ob=Guidewire.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Guidewire.class.getDeclaredMethod("getProducts");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
