package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Rakuten;
import utilities.seleniumUtilities;

public class RakutenTest extends Baseclass {
	
	
	
	@Test
	void getRakutenBusinesses() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://global.rakuten.com/corp/", driver);
		Rakuten ob=Rakuten.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=Rakuten.class.getDeclaredMethod("getBusinesses");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
