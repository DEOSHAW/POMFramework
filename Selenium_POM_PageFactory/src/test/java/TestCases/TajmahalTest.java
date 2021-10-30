package TestCases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Tajmahal;
import utilities.seleniumUtilities;

public class TajmahalTest extends Baseclass {
	
	@Test
	void findMonuments() throws Exception
	{
		seleniumUtilities.LaunchBrowser("http://www.tajmahal.gov.in/", driver);
		Class clazz=Tajmahal.class;
		Tajmahal Taj=(Tajmahal) clazz.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=clazz.getDeclaredMethod("displayMonumentsToVisitInAgra");
		m.setAccessible(true);
		m.invoke(Taj);
		
		
		
	}

}
