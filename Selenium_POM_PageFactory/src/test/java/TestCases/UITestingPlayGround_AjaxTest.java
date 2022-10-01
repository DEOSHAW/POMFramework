package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.UITestingPlayGround_Ajax;
import utilities.seleniumUtilities;

public class UITestingPlayGround_AjaxTest extends Baseclass {
	
	
	
	@Test
	void testAjaxCallOnUI() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://uitestingplayground.com/ajax", driver);
		UITestingPlayGround_Ajax ob=UITestingPlayGround_Ajax.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UITestingPlayGround_Ajax.class.getDeclaredMethod("triggerAjaxRequest");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
