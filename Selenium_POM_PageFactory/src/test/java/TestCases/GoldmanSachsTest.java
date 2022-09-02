package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GoldmanSachs;
import utilities.seleniumUtilities;

public class GoldmanSachsTest extends Baseclass {
	
	
	
	@Test
	void getGoldmanSachsProductsAndServices() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.goldmansachs.com/", driver);
		GoldmanSachs ob=GoldmanSachs.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GoldmanSachs.class.getDeclaredMethod("getProductAndServices");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
