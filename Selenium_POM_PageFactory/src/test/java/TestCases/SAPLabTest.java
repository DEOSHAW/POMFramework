package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SAPLabs;
import utilities.seleniumUtilities;

public class SAPLabTest extends Baseclass {
	
	@Test
	void getSAPLocations() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.sap.com/india/about/company/innovation/labs.html", driver);
		SAPLabs.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).getAsiaPacificLocations();
		
	}

}
