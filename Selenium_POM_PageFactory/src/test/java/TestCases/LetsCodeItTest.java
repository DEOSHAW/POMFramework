package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.LetsCodeIt;
import utilities.seleniumUtilities;

public class LetsCodeItTest extends Baseclass
{
	
	@Test
	void validateDropdown() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.letskodeit.com/practice", driver);
		LetsCodeIt ob=LetsCodeIt.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=LetsCodeIt.class.getDeclaredMethod("selectFromDropdown",String.class);
		m.setAccessible(true);
		String vehiceName=seleniumUtilities.getDataForKey("VEHICLE_NAME");
		String selectedVehicle=(String) m.invoke(ob, vehiceName);
		Assert.assertEquals(selectedVehicle, vehiceName);
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
