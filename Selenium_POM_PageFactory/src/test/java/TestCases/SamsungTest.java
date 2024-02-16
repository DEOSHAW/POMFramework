package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Samsung;
import utilities.seleniumUtilities;

public class SamsungTest extends Baseclass
{
	@Test
	void getAllSamsungRefrigerators() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.samsung.com/in/", driver);
		Samsung ob=Samsung.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Samsung.class.getDeclaredMethod("getAllRefrigerators");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
