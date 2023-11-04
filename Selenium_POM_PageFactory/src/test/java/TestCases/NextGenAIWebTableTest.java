package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NextGenAIWebTable;
import utilities.seleniumUtilities;

public class NextGenAIWebTableTest extends Baseclass{
	
	
	
	@Test
	void printNextGenAIWebTable() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		
		seleniumUtilities.LaunchBrowser("https://nxtgenaiacademy.com/", driver);
		NextGenAIWebTable ob=NextGenAIWebTable.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NextGenAIWebTable.class.getDeclaredMethod("printWebTable");
		m.setAccessible(true);
		m.invoke(ob);
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
