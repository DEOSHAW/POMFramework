package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingDropdown;
import utilities.seleniumUtilities;

public class AutomationTestingDropdownTest extends Baseclass
{
	@Test
	void validateDropdownSelection() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/dropdown.html", driver);
		AutomationTestingDropdown ob=AutomationTestingDropdown.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingDropdown.class.getDeclaredMethod("selectVehicle", String.class);
		m.setAccessible(true);
		String vehicleName=seleniumUtilities.getDataForKey("VEHICLE_NAME");
		String selectedVehicle=(String) m.invoke(ob,vehicleName);
		Assert.assertEquals(selectedVehicle, vehicleName);
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
