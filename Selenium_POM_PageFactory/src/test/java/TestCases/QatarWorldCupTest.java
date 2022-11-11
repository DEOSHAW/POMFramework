package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.QatarWorldCup;
import utilities.seleniumUtilities;

public class QatarWorldCupTest extends Baseclass {
	
	
	@Test
	void getFanFestivalEventDetails() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.qatar2022.qa/en", driver);
		QatarWorldCup ob=QatarWorldCup.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=QatarWorldCup.class.getDeclaredMethod("getFanFestivalInformation");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
