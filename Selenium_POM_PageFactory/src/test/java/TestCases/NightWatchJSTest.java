package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.NightWatchJS;
import utilities.seleniumUtilities;

public class NightWatchJSTest extends Baseclass {
	
	
	
	@Test
	void getNightWatchJSMediaInfo() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://nightwatchjs.org/", driver);
		NightWatchJS ob=NightWatchJS.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NightWatchJS.class.getDeclaredMethod("getMediaInfo");
		m.setAccessible(true);
		m.invoke(ob);
		
	}
	@Test
	void getNightWatchJSMediaInfo1() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://nightwatchjs.org/", driver);
		NightWatchJS ob=NightWatchJS.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NightWatchJS.class.getDeclaredMethod("getMediaInfo");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
