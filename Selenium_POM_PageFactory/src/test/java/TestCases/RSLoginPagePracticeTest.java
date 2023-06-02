package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.RSLoginPagePractice;
import utilities.seleniumUtilities;

public class RSLoginPagePracticeTest extends Baseclass {
	
	
	
	
	
	@Test
	void addProductsToCart() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://rahulshettyacademy.com/loginpagePractise/", driver);
		RSLoginPagePractice ob=RSLoginPagePractice.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m1=RSLoginPagePractice.class.getDeclaredMethod("login");
		m1.setAccessible(true);
		m1.invoke(ob);
		
		Method m2=RSLoginPagePractice.class.getDeclaredMethod("addToCart");
		m2.setAccessible(true);
		m2.invoke(ob);
		
		
	}

}
