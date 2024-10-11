package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ViaBenefitsParticipantLogin;
import utilities.seleniumUtilities;

public class ViaBenefitsParticipantLoginTest extends Baseclass
{
	@Test
	void loginViaBenefitsAsParticipantWithWrongCredentials() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.viabenefitsaccounts.com/benefits/logindisplay.jsp?app=docmgmt&mode=S", driver);
		ViaBenefitsParticipantLogin ob=ViaBenefitsParticipantLogin.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ViaBenefitsParticipantLogin.class.getDeclaredMethod("loginAsParticipantWithWrongCredentials");
		m.setAccessible(true);
		String errorMessage=(String) m.invoke(ob);
		Assert.assertEquals(errorMessage, "Invalid User Credentials");
		test.log(LogStatus.PASS, "Error message displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
