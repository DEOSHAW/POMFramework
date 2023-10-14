package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GumTree;
import utilities.seleniumUtilities;

public class GumTreeTest extends Baseclass
{
	
	
	@Test
	void getListOfGumTreeServices() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.gumtree.com/", driver);
		GumTree ob=GumTree.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GumTree.class.getDeclaredMethod("getListOfServices");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
