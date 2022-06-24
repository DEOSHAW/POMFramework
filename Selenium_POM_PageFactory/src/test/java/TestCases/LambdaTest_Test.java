package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.LambdaTest;
import utilities.seleniumUtilities;

public class LambdaTest_Test extends Baseclass {
	
	
	
	@Test
	void getInfo() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.lambdatest.com/selenium-playground/window-popup-modal-demo", driver);
		LambdaTest ob=LambdaTest.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=LambdaTest.class.getDeclaredMethod("getInfoFromTwitter");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
