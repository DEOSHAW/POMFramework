package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.EcoPark;
import utilities.seleniumUtilities;

public class EcoParkTest extends Baseclass {
	
	@Test
	void getActivitiesListAtEcoPark() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://ecoparknewtown.com/", driver);
		EcoPark ob=EcoPark.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=EcoPark.class.getDeclaredMethod("getActivitiesList");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
