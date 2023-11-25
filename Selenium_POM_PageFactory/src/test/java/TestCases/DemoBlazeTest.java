package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.DemoBlaze;
import utilities.seleniumUtilities;

public class DemoBlazeTest extends Baseclass
{
	
	
	@Test
	void addProductToCartOnDemoBlazePortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.demoblaze.com/", driver);
		String requiredProduct=seleniumUtilities.getDataForKey("DEMOBLAZE_PRODUCT_TO_ADD");
		DemoBlaze ob=DemoBlaze.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=DemoBlaze.class.getDeclaredMethod("addProductToCart", String.class);
		m.setAccessible(true);
		String productInCart=(String) m.invoke(ob, requiredProduct);
		Assert.assertEquals(productInCart, requiredProduct);
		test.log(LogStatus.PASS, "Product added to cart");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
