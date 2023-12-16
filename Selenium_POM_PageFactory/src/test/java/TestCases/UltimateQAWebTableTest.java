package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UltimateQAWebTable;
import utilities.seleniumUtilities;

public class UltimateQAWebTableTest extends Baseclass {
	
	
	@Test
	void getRoleWebTableData() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://ultimateqa.com/automation/?ref=hackernoon.com", driver);
		UltimateQAWebTable ob=UltimateQAWebTable.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UltimateQAWebTable.class.getDeclaredMethod("getWebTableData");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Web table printed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
