package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Paytm;
import utilities.seleniumUtilities;

public class PaytmTest extends Baseclass {
	
	
	@Test
	void getListOfFinancialServices() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://paytm.com/", driver);
		Paytm ob=Paytm.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Paytm.class.getDeclaredMethod("getListOfFinServices");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
