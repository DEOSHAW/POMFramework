package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.KEC;
import utilities.seleniumUtilities;

public class KECTest extends Baseclass
{
	@Test
	void highlightMenuOptionsInKEC() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.kecrpg.com/", driver);
		KEC ob=KEC.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=KEC.class.getDeclaredMethod("highlightMenuOptions");
		m.invoke(ob);
		test.log(LogStatus.PASS, "Menu options got highlighted");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
