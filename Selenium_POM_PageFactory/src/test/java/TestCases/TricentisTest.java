package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Tricentis;
import utilities.seleniumUtilities;

public class TricentisTest extends Baseclass {
	
	
	
	@Test
	void getTricentisProducts() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.tricentis.com/", driver);
		Tricentis ob=Tricentis.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Tricentis.class.getDeclaredMethod("getProducts");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
