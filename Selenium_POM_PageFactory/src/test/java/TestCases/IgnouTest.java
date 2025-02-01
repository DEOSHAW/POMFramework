package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Ignou;
import utilities.seleniumUtilities;

public class IgnouTest extends Baseclass
{
	
	@Test
	void PrintIgnouAdverstisementsTable() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.ignou.ac.in/", driver);
		Ignou ob=Ignou.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Ignou.class.getDeclaredMethod("PrintAdvertisementTable");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Advertisement table printed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
