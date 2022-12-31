package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.RSPracticePageWebTable;
import utilities.seleniumUtilities;

public class RSPracticePageWebTableTest extends Baseclass {
	
	
	
	@Test
	void printRSPracticeWebTable() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://rahulshettyacademy.com/AutomationPractice/", driver);
		RSPracticePageWebTable ob=RSPracticePageWebTable.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=RSPracticePageWebTable.class.getDeclaredMethod("printWebTable");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
