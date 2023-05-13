package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.WTW;
import utilities.seleniumUtilities;

public class WTWTest extends Baseclass
{
	
	
	@Test
	void serachOnWTWPortal() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.wtwco.com/en-IN", driver);
		WTW ob=WTW.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=WTW.class.getDeclaredMethod("aboutInfo");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
