package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SemanticUI;
import utilities.seleniumUtilities;

public class SemanticUIDropdownTest extends Baseclass
{
	
	@Test
	void handleMultiSelectDropdownonSemanticUIPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://semantic-ui.com/", driver);
		SemanticUI ob=SemanticUI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SemanticUI.class.getDeclaredMethod("selectValuesFromDropdown");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Value selected from dropdown");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}
	

}
