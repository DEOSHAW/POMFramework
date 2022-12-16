package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MenaTour;
import utilities.seleniumUtilities;

public class MenaTourTest extends Baseclass {
	
	@Test
	void getTopTenOOM_MenaTour() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://menatour.golf", driver);
		
		MenaTour ob=MenaTour.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=MenaTour.class.getDeclaredMethod("getTopTenOrderOfMerit");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
