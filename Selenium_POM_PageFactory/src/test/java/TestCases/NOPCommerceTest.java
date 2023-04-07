package TestCases;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.NOPCommerce;
import utilities.seleniumUtilities;

public class NOPCommerceTest extends Baseclass
{
	
	@Test
	void addPhoneToCart() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://demo.nopcommerce.com/", driver);
		NOPCommerce ob=NOPCommerce.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NOPCommerce.class.getDeclaredMethod("addParticularPhoneToCart", String.class);
		m.setAccessible(true);
		boolean cartStatus=(Boolean) m.invoke(ob, seleniumUtilities.getDataForKey("MOBILE_NAME"));
		System.out.println(cartStatus);
		Assert.assertTrue(cartStatus,"Product not correctly added");
		
		
	}

}
