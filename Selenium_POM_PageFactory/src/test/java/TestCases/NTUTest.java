package TestCases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.NTU;
import utilities.seleniumUtilities;

public class NTUTest extends Baseclass {
	
	@Test
	void displayNTUAchievements() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.ntu.edu.sg/", driver);
		NTU ob=NTU.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NTU.class.getDeclaredMethod("getListOfNTUAchievements");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
