package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ExpandTesting;
import utilities.seleniumUtilities;

public class ExpandTestingTest extends Baseclass
{
	@Test
	void getMenuFromExpandTestingPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practice.expandtesting.com/", driver);
		ExpandTesting ob=ExpandTesting.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ExpandTesting.class.getDeclaredMethod("getMenu");
		m.setAccessible(true);
		List<String> menuList=(List<String>) m.invoke(ob);
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(menuList.get(0), "Demos");
		softAssert.assertEquals(menuList.get(3), "About");
		softAssert.assertAll();
		test.log(LogStatus.PASS, "Assertions successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
