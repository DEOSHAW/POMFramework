package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MLF;
import utilities.seleniumUtilities;

public class MLF_Test extends Baseclass {
	
	
	@Test
	void getTopAnglersList() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://majorleaguefishing.com/circuits/bass-pro-tour/standings/", driver);
		MLF ob=MLF.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MLF.class.getDeclaredMethod("getTop10Angelers");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
