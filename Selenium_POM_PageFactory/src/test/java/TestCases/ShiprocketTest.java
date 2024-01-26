package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Shiprocket;
import utilities.seleniumUtilities;

public class ShiprocketTest extends Baseclass
{
	
	
	@Test
	void getShiprocketShippingProducts() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.shiprocket.in/", driver);
		Shiprocket ob=Shiprocket.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Shiprocket.class.getDeclaredMethod("getShippingProducts");
		test.log(LogStatus.PASS, "All Shipping products displayed");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
