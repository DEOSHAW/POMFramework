package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingTables;
import utilities.seleniumUtilities;

public class AutomationTestingTablesTest extends Baseclass
{
	@Test
	void printTableData() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/tables.html", driver);
		AutomationTestingTables ob=AutomationTestingTables.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingTables.class.getDeclaredMethod("printTable");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
