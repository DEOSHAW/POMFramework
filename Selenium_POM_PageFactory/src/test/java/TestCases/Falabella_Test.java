package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Falabella;
import utilities.seleniumUtilities;

public class Falabella_Test extends Baseclass {
	
	
	
	@Test
	void getBusinessUnits() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://investors.falabella.com/English/about-us/default.aspx", driver);
		Falabella ob=Falabella.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Falabella.class.getDeclaredMethod("getBusinessUnitsNames");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
