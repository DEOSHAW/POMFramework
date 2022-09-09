package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.LIVGolf;
import utilities.seleniumUtilities;

public class LIVGolfTest extends Baseclass {
	
	
	
	@Test
	void getLIVGolfMotto() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.livgolf.com/", driver);
		LIVGolf ob=LIVGolf.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=LIVGolf.class.getDeclaredMethod("getMotto");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
