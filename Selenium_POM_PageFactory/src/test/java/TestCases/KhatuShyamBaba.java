package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.KhatuShyam;
import utilities.seleniumUtilities;

public class KhatuShyamBaba extends Baseclass{
	
	
	
	@Test
	void getFontAndStyle() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://khatushyamdarbar.com/", driver);
		KhatuShyam ob=KhatuShyam.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Class clazz=ob.getClass();
		Method m=clazz.getDeclaredMethod("getCssAttributes");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
