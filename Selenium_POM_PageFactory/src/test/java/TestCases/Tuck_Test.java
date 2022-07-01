package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Tuck;
import utilities.seleniumUtilities;

public class Tuck_Test extends Baseclass {
	
	
	
	@Test
	void getRecruitersList() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.tuck.dartmouth.edu/", driver);
		Tuck ob=Tuck.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Tuck.class.getDeclaredMethod("getTopRecruitingCompanies");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
