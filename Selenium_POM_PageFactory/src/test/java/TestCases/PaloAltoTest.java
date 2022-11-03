package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.PaloAlto;
import utilities.seleniumUtilities;

public class PaloAltoTest extends Baseclass {
	
	
	@Test
	void getPaloAltoAboutText() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.paloaltonetworks.com/", driver);
		PaloAlto ob=PaloAlto.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=PaloAlto.class.getDeclaredMethod("getAboutText");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
