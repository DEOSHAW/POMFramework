package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Udemy;
import utilities.seleniumUtilities;

public class UdemyTest extends Baseclass
{
	@Test
	void validateNavigationToUdemy() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.udemy.com/", driver);
		Udemy ob=Udemy.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Udemy.class.getDeclaredMethod("getSiteUrl");
		m.setAccessible(true);
		String pageUrl=(String) m.invoke(ob);
		Assert.assertEquals(pageUrl, "https://www.udemy.com/");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");	
	}

}
