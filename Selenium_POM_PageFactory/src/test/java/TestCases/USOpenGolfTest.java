package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.USOpenGolf;
import utilities.seleniumUtilities;

public class USOpenGolfTest extends Baseclass {
	
	
	
	@Test
	void getTop10InLeaderBoardAtUSOpen() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.usopen.com/", driver);
		USOpenGolf ob=USOpenGolf.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=USOpenGolf.class.getDeclaredMethod("getTop10InTheLeaderBoard");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
