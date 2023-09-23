package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MarshMcLennan;
import utilities.seleniumUtilities;

public class MarshMcLennanTest extends Baseclass
{
	
	
	@Test
	void getMarshMcLennanSolutions() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.marshmclennan.com/", driver);
		MarshMcLennan ob=MarshMcLennan.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MarshMcLennan.class.getDeclaredMethod("getSolutions");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
