package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.CreditSuisse;
import utilities.seleniumUtilities;

public class CreditSuisseTest extends Baseclass {
	
	@Test
	void getCreditSuisseLocations() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.credit-suisse.com/in/en.html", driver);
		CreditSuisse ob=CreditSuisse.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=CreditSuisse.class.getDeclaredMethod("getCreditSuisseLocation");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
