package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.TGL_Golf;
import utilities.seleniumUtilities;

public class TGL_Golf_Test extends Baseclass
{
	
	
	@Test
	void getTglGolfPlayerNames() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://tglgolf.com/", driver);
		TGL_Golf ob=TGL_Golf.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=TGL_Golf.class.getDeclaredMethod("getPlayerNames");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
