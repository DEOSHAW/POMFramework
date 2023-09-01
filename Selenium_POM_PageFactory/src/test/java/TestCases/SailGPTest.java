package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SailGP;
import utilities.seleniumUtilities;

public class SailGPTest extends Baseclass {
	
	
	@Test
	void sailGPDriversRankings() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://sailgp.com/", driver);
		SailGP ob=SailGP.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=SailGP.class.getDeclaredMethod("getDriversRankings");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
