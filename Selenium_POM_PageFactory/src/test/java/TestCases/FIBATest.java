package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.FIBA;
import utilities.seleniumUtilities;

public class FIBATest extends Baseclass {
	
	
	
	@Test
	void getTop10FIBARankings() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.fiba.basketball/", driver);
		FIBA ob=FIBA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=FIBA.class.getDeclaredMethod("getTop10Rankings");
		m.setAccessible(true);
		m.invoke(ob);
		
	 }

}
