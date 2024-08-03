package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ExpandTesting_DynamicTable;
import utilities.seleniumUtilities;

public class ExpandTesting_DynamicTableTest extends Baseclass
{
	@Test
	void printTaskManagerTable()throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practice.expandtesting.com/dynamic-table", driver);
		ExpandTesting_DynamicTable ob=ExpandTesting_DynamicTable.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ExpandTesting_DynamicTable.class.getDeclaredMethod("printTableValues");
		m.setAccessible(true);
		m.invoke(ob);	
		test.log(LogStatus.PASS, "Table data printed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
