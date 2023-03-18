package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.JavaTPoint;
import utilities.seleniumUtilities;

public class JavaTPointTest extends Baseclass {
	
	
	@Test
	void getJavaTPointTutorialList() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.javatpoint.com/", driver);
		JavaTPoint ob=JavaTPoint.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=JavaTPoint.class.getDeclaredMethod("getTutorialList");
		
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
