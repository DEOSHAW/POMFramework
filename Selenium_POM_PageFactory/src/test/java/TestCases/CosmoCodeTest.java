package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.CosmoCode;
import utilities.seleniumUtilities;

public class CosmoCodeTest extends Baseclass {
	
	
	
	@Test
	void selectCountryOnCosmoCodePortal() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://cosmocode.io/automation-practice-webtable/", driver);
		
		CosmoCode ob=CosmoCode.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=CosmoCode.class.getDeclaredMethod("selectCountry");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
