package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ViaBenefits;
import utilities.seleniumUtilities;

public class ViaBenefitsTest extends Baseclass
{
	@Test
	void signUpOnViaBenefitsWithWrongSSN() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.viabenefits.com/", driver);
		ViaBenefits ob=ViaBenefits.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ViaBenefits.class.getDeclaredMethod("signUpWithWrongErCode");
		m.setAccessible(true);
		m.invoke(ob);	
		test.log(LogStatus.PASS, "Error message displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
