package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.IIMA;
import utilities.seleniumUtilities;

public class IIMATest extends Baseclass {
	
	
	@Test
	void getCoursesAtIIMA() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.iima.ac.in/", driver);
		IIMA ob=IIMA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Class clazz=ob.getClass();
		Method m=clazz.getDeclaredMethod("getListOfCourses");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
