package TestCases;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TutorialsPointDropDown;
import utilities.seleniumUtilities;

public class TutorialsPointDropDownTest extends Baseclass
{
	@Test
	void SelectFromDropdownOnTutorialsPoint() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tutorialspoint.com/selenium/practice/select-menu.php", driver);
		TutorialsPointDropDown ob=TutorialsPointDropDown.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TutorialsPointDropDown.class.getDeclaredMethod("SelectFromDropdown",List.class);
		m.setAccessible(true);
		List<String> values = Arrays.asList("Mr.","Dr.");
		boolean selected=(boolean) m.invoke(ob,values);
		Assert.assertTrue(selected, "Value not Selected");
		test.log(LogStatus.PASS, "Value Selected");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
