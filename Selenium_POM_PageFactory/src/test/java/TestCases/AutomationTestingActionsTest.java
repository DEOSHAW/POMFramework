package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingActions;
import utilities.seleniumUtilities;

public class AutomationTestingActionsTest extends Baseclass
{
	@Test
	void validateHoldShiftAndClickAction() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/actions.html", driver);
		AutomationTestingActions ob=AutomationTestingActions.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingActions.class.getDeclaredMethod("holdShiftAndClick");
		m.setAccessible(true);
		String successMessage=(String) m.invoke(ob);
		System.out.println(successMessage);
		Assert.assertEquals(successMessage, "The SHIFT key was pressed!");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
