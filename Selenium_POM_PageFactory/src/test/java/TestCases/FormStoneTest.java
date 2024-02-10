package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FormStone;
import utilities.seleniumUtilities;

public class FormStoneTest extends Baseclass
{

	@Test
	void testDropDown() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://formstone.it/components/dropdown/demo/", driver);
		FormStone ob=FormStone.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=FormStone.class.getDeclaredMethod("selectDropdownValues");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Dropdown operations performed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}
}
