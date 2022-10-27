package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.UCLA;
import utilities.seleniumUtilities;

public class UCLA_Test extends Baseclass {
	
	
	
	@Test
	void getUCLA_AcademicDetails() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.ucla.edu/", driver);
		UCLA ob=UCLA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UCLA.class.getDeclaredMethod("getAcademicDetails");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
