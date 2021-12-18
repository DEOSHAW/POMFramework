package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PDF995;
import utilities.seleniumUtilities;

public class PDF995Test extends Baseclass {
	
	@Test
	void testPDFFile() throws Exception
	{
		//seleniumUtilities.LaunchBrowser("http://www.pdf995.com/samples/pdf.pdf", driver);
		PDF995 ob=PDF995.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
	    Method m=ob.getClass().getDeclaredMethod("testPDF");
	    m.setAccessible(true);
	    m.invoke(ob);
		
	}

}
