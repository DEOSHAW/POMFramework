package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.JIO;
import utilities.seleniumUtilities;

public class JIO_Test extends Baseclass {
	
	
	@Test
	void getJIOPopularPlanDetails() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.jio.com/", driver);
		Thread.sleep(4000);
		JIO ob=JIO.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=JIO.class.getDeclaredMethod("getJIO_PlanDetails");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
