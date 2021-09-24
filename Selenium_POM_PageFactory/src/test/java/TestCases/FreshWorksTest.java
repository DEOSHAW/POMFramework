package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.FreshWorks;
import utilities.seleniumUtilities;

public class FreshWorksTest extends Baseclass {
	
	@Test
	void testFreshWorks() throws Exception	{
		
		seleniumUtilities.LaunchBrowser("https://www.freshworks.com/", driver);
		FreshWorks ob=FreshWorks.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		FreshWorks.class.getMethod("getListOfFreshworkProducts").invoke(ob);
		
	}

}
