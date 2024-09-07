package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Airtel;
import utilities.seleniumUtilities;

public class AirtelTest extends Baseclass
{
	@Test
	void validateErrorMessageForRechargeOfWrongNumber() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.airtel.in/", driver);
		Airtel ob=Airtel.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		String errorMessageText=ob.rechargeWithWrongNumber(seleniumUtilities.getDataForKey("MOBILE_NUMBER"));
		Assert.assertEquals(errorMessageText, "Please enter a valid mobile number.");
		test.log(LogStatus.PASS, "Validation of incorrect number successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
