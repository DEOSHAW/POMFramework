package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Hexaware;
import utilities.seleniumUtilities;

public class HexawareTest extends Baseclass {
	
	
	
	
	@Test
	void getStrategy() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://hexaware.com/", driver);
		Hexaware ob=Hexaware.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Hexaware.class.getDeclaredMethod("getHexawareStrategy");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
