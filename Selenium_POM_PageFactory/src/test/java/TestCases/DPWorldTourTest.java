package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.DPWorldTour;
import utilities.seleniumUtilities;

public class DPWorldTourTest extends Baseclass
{
	
	@Test
	void getTop5OnDPWorldTour() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.europeantour.com/dpworld-tour/", driver);
		DPWorldTour ob=DPWorldTour.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=DPWorldTour.class.getDeclaredMethod("getTop5OnTour");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
