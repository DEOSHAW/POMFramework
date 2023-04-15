package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Intellias;
import utilities.seleniumUtilities;

public class IntelliasTest extends Baseclass
{
	
	@Test
	void getIntelliasExpertiseAreas() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://intellias.com/", driver);
		Intellias ob=Intellias.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=Intellias.class.getDeclaredMethod("getExpertiseAreas");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
