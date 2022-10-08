package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.UITestingPlayground_OverlappingElements;
import utilities.seleniumUtilities;

public class UITestingPlayground_OverlappingElementsTest extends Baseclass {
	
	@Test
	void typeInOverlappedTextBox() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://uitestingplayground.com/overlapped", driver);
		UITestingPlayground_OverlappingElements ob=UITestingPlayground_OverlappingElements.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UITestingPlayground_OverlappingElements.class.getDeclaredMethod("enterTextInOverlappedTextBox",String.class);
		m.setAccessible(true);
		m.invoke(ob,seleniumUtilities.getDataForKey("NAME_TEXT"));
	}

}
