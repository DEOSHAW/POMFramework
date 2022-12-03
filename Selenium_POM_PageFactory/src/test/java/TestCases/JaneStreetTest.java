package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.JaneStreet;
import utilities.seleniumUtilities;

public class JaneStreetTest extends Baseclass {
	
	
	@Test
	void getwhatJaneStreetDo() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.janestreet.com/", driver);
		JaneStreet ob=JaneStreet.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=JaneStreet.class.getDeclaredMethod("getInformationOnWhatWeDo");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
