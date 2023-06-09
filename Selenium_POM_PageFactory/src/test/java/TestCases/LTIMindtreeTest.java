package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;


import Base.Baseclass;
import Pages.LTIMindtree;
import utilities.seleniumUtilities;

public class LTIMindtreeTest extends Baseclass{
	
	
	
	@Test 
	void getLTIMindtreePartners() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.ltimindtree.com/", driver);
		LTIMindtree ob=LTIMindtree.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
	    Method m=LTIMindtree.class.getDeclaredMethod("getPartners");
	    m.setAccessible(true);
	    m.invoke(ob);
		
		
	}

}
