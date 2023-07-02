package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ProKabaddi;
import utilities.seleniumUtilities;

public class ProKabaddiTest extends Baseclass {
	
	
	@Test
	void getProKabaddiTeamNames() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.prokabaddi.com/", driver);
		ProKabaddi ob=ProKabaddi.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ProKabaddi.class.getDeclaredMethod("getTeamNames");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
