package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SeleniumBaseIoDropdown;
import utilities.seleniumUtilities;

public class SeleniumBaseIoDropdownTest extends Baseclass
{
	
	@Test
	void getSelectedItemFromDropdown() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page/", driver);
		SeleniumBaseIoDropdown ob=SeleniumBaseIoDropdown.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SeleniumBaseIoDropdown.class.getDeclaredMethod("getSelectedItem",String.class);
		m.setAccessible(true);
		String selectItem=seleniumUtilities.getDataForKey("ITEM_TO_SELECT");
		String selectedItem=(String) m.invoke(ob,selectItem);
		Assert.assertEquals(selectedItem, selectItem);
		test.log(LogStatus.PASS, "Correct item selected");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
