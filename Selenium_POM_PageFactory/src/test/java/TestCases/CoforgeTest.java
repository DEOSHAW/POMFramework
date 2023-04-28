package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Coforge;
import utilities.seleniumUtilities;

public class CoforgeTest extends Baseclass
{
	
	
	@Test
	void testDisplayListOfServices() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.coforge.com/", driver);
		Coforge ob=Coforge.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Coforge.class.getDeclaredMethod("displayListOfServices");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
