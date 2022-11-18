package TestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.UITP_ShadowDom;
import utilities.seleniumUtilities;

public class UITP_ShadowDomTest extends Baseclass {
	
	
	@Test
	void testGUIDGenerator() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://uitestingplayground.com/shadowdom", driver);
		Constructor c=UITP_ShadowDom.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class);
		c.setAccessible(true);
		UITP_ShadowDom ob=(UITP_ShadowDom) c.newInstance(driver,test);
		
		Method m=UITP_ShadowDom.class.getDeclaredMethod("generateGUID");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
