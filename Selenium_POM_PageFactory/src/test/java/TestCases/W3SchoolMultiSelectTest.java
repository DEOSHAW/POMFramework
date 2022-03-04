package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.W3SchoolMultiSelect;
import utilities.seleniumUtilities;

public class W3SchoolMultiSelectTest extends Baseclass {
	
	
	
	@Test
	void testSelectMultipleOptionsFromDropdown() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple", driver);
		W3SchoolMultiSelect ob=W3SchoolMultiSelect.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=W3SchoolMultiSelect.class.getDeclaredMethod("selectMultipleCars");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
