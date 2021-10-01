package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Guru99Cookies;
import utilities.seleniumUtilities;

public class Guru99CookiesTest extends Baseclass {
	
	
	@Test
	void testGuru99CookiesScenario() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://demo.guru99.com/test/cookie/selenium_aut.php", driver);
		Guru99Cookies ob=Guru99Cookies.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Guru99Cookies.class.getDeclaredMethod("logintoGuru99").invoke(ob);
		Thread.sleep(5000);
		

    }
}
