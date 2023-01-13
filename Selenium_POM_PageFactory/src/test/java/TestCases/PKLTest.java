package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PKL;
import utilities.seleniumUtilities;

public class PKLTest extends Baseclass {
	
	
	
	@Test
	void getPKLStandings() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.prokabaddi.com/", driver);
		PKL ob=PKL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=PKL.class.getDeclaredMethod("getStandings");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
