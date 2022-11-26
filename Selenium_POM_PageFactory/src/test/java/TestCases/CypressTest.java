package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Cypress;
import utilities.seleniumUtilities;

public class CypressTest extends Baseclass {
	
	
	
	@Test
	void getCypressPricing() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.cypress.io/", driver);
		Cypress ob=Cypress.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=Cypress.class.getDeclaredMethod("getPricing");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
