package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Xerox;
import utilities.seleniumUtilities;

public class XeroxTest extends Baseclass {
	
	@Test
	void textXeroxSite() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.xerox.com/index/enin.html", driver);
		Xerox ob=Xerox.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Xerox.class.getMethod("getSolutionAndServices").invoke(ob);
		
	}

}
