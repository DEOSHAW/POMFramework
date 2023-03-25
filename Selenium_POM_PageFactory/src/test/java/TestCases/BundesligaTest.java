package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Bundesliga;
import utilities.seleniumUtilities;

public class BundesligaTest extends Baseclass
{
	
	
	@Test
	void getBundesligaStandings() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.bundesliga.com/en/bundesliga", driver);
		Bundesliga ob=Bundesliga.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Bundesliga.class.getDeclaredMethod("getStandings");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
