package TestCases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.AccionLabs;
import utilities.seleniumUtilities;

public class AccionLabsTest extends Baseclass {
	
	
	
	@Test
	void getTechnologyLeversOfInnovation() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.accionlabs.com/", driver);
		AccionLabs ob=AccionLabs.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=AccionLabs.class.getDeclaredMethod("getTechLeversOfInnovations");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
