package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.BlackRock;
import utilities.seleniumUtilities;

public class BlackRockTest extends Baseclass{
	
	@Test
	void GetInformationAboutBlackRock() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.blackrock.com/corporate", driver);
		BlackRock ob=BlackRock.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=BlackRock.class.getDeclaredMethod("getInformation");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
