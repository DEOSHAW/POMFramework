package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.DemoQA;
import utilities.seleniumUtilities;

public class DemoQATest_PracticeForm extends Baseclass {
	
	
	
	@Test
	void testPracticeForm() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://demoqa.com/automation-practice-form", driver);
		DemoQA ob=DemoQA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=DemoQA.class.getDeclaredMethod("fillRegistrationForm");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
