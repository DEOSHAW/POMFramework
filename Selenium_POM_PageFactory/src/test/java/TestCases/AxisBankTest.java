package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AxisBank;
import utilities.seleniumUtilities;

public class AxisBankTest extends Baseclass
{
	@Test
	void getAxisBurgundyColour() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.axis.bank.in/", driver);
		AxisBank ob=AxisBank.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AxisBank.class.getDeclaredMethod("getBackgroundBurgundyColour");
		m.setAccessible(true);
		String backgroundColour=(String) m.invoke(ob);
		Assert.assertEquals(backgroundColour, "#000000");
		test.log(LogStatus.PASS, "background colour validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
