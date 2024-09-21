package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.QSpiderDropdown;
import utilities.seleniumUtilities;

public class QSpiderDropdownTest extends Baseclass
{
	
	@Test
	void validateCheckout() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://demoapps.qspiders.com/ui/dropdown?sublist=0", driver);
		test.log(LogStatus.PASS, "Test Started");
		QSpiderDropdown ob=QSpiderDropdown.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=QSpiderDropdown.class.getDeclaredMethod("navigateToCheckOutPage");
		m.setAccessible(true);
		boolean isCheckoutPage=(boolean) m.invoke(ob);
		Assert.assertTrue(isCheckoutPage, "Not on Checkout Page");
		test.log(LogStatus.PASS, "User is on checkout page");
		test.log(LogStatus.PASS, "Test Ended");
				
	}

}
