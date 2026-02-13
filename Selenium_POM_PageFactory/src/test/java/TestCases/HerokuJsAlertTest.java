package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuJsAlert;
import utilities.seleniumUtilities;

public class HerokuJsAlertTest extends Baseclass
{
	@Test
	void validateHerokuAlert() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/javascript_alerts", driver);
		HerokuJsAlert ob=HerokuJsAlert.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuJsAlert.class.getDeclaredMethod("getAlertText",String.class);
		m.setAccessible(true);
		String alertText=(String) m.invoke(ob,seleniumUtilities.getDataForKey("JS_BUTTON_NAME"));
		System.out.println(alertText);
		Assert.assertEquals(alertText, seleniumUtilities.getDataForKey("ALERT_TEXT"));
		test.log(LogStatus.PASS, "Validation for alert text successful!");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
