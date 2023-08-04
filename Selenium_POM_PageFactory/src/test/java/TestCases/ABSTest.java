package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ABS;
import utilities.seleniumUtilities;

public class ABSTest extends Baseclass{
	
	
	
	@Test
	void getABSPrograms() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.amity.edu/abs/", driver);
		ABS ob=ABS.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ABS.class.getDeclaredMethod("getPrograms");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
