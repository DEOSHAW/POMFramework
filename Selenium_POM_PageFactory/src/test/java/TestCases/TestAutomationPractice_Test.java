package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.TestAutomationPractice;
import utilities.seleniumUtilities;

public class TestAutomationPractice_Test extends Baseclass
{
	
	@Test
	void testDrapAndDrop() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://testautomationpractice.blogspot.com/", driver);
		TestAutomationPractice ob=TestAutomationPractice.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=TestAutomationPractice.class.getDeclaredMethod("dragAndDrop");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
