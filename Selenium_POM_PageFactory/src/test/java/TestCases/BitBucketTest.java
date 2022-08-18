package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.BitBucket;
import utilities.seleniumUtilities;

public class BitBucketTest extends Baseclass {
	
	
	
	@Test
	void getBitBucketOverview() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://bitbucket.org/product", driver);
		BitBucket ob=BitBucket.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=BitBucket.class.getDeclaredMethod("getProductOverview");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
