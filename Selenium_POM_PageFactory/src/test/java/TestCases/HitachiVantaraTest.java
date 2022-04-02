package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.HitachiVantara;
import utilities.seleniumUtilities;

public class HitachiVantaraTest extends Baseclass {
	
	@Test
	void getHitachiProducts() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.hitachivantara.com/en-in/home.html", driver);
		HitachiVantara ob=HitachiVantara.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=HitachiVantara.class.getDeclaredMethod("getProducts");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
