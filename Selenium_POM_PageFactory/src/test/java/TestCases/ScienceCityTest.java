package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.AADHAR;
import Pages.ScienceCity;
import utilities.seleniumUtilities;

public class ScienceCityTest extends Baseclass {
	
	
	
	@Test
	void getTicketPrices() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://sciencecitykolkata.org.in/", driver);
		ScienceCity ob=ScienceCity.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ob.getClass().getDeclaredMethod("getPrices");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
