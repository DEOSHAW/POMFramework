package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SeleniumBaseDemo;
import utilities.seleniumUtilities;

public class SeleniumBaseDemoTest extends Baseclass {
	
	
	
	@Test
	void testCopyPasteText() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page", driver);
		SeleniumBaseDemo ob=SeleniumBaseDemo.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=SeleniumBaseDemo.class.getDeclaredMethod("copyPasteText");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
