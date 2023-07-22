package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PluralSight;
import utilities.seleniumUtilities;


public class PluralSightTest extends Baseclass{
	
	
	@Test
	void getPluralSightIndividualPlans() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.pluralsight.com/", driver);
		PluralSight ob=PluralSight.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=PluralSight.class.getDeclaredMethod("getIndividualPlans");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
