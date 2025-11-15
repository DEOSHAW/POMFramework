package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Nitto;
import utilities.seleniumUtilities;

public class NittoTest extends Baseclass
{
	@Test
	void navigateToNittoIndiaWebsite() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.nitto.com/", driver);
		Nitto ob=Nitto.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Nitto.class.getDeclaredMethod("navigateToIndiaWebSite");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		Assert.assertEquals(pageTitle, "Nitto in India");
		test.log(LogStatus.PASS, "Successfully navigated to India Nitto Website");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
