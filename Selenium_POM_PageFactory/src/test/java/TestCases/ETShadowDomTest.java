package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ETShadowDom;
import utilities.seleniumUtilities;

public class ETShadowDomTest extends Baseclass
{
	@Test
	void getTextOfButtonInsideShadowDom() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practice.expandtesting.com/shadowdom", driver);
		ETShadowDom ob=ETShadowDom.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ETShadowDom.class.getDeclaredMethod("getTextOfButton");
		m.setAccessible(true);
		String buttonText=(String) m.invoke(ob);
		Assert.assertEquals(buttonText, "This button is inside a Shadow DOM.");
		test.log(LogStatus.PASS, "Text of button validated");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
