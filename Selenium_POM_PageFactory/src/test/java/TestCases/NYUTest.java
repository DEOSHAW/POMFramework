package TestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NYU;
import utilities.seleniumUtilities;

public class NYUTest extends Baseclass
{
	@Test
	void ValidateErrorMessageOnNYUSite() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.nyu.edu/", driver);
		Constructor construct=NYU.class.getDeclaredConstructor(WebDriver.class);
		construct.setAccessible(true);
		NYU ob=(NYU) construct.newInstance(driver);
		Method m=NYU.class.getDeclaredMethod("getErrorMessage");
		m.setAccessible(true);
		String actualErrorMessage=(String) m.invoke(ob);
		Assert.assertEquals(actualErrorMessage, "You don't have permission to access this resource.");
		test.log(LogStatus.PASS, "All links identified");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
