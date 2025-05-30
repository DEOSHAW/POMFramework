package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.DynamicTablePage;
import utilities.seleniumUtilities;

public class DynamicTableTest extends Baseclass
{
	@Test
	void getDynamicTableData() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practice.expandtesting.com/dynamic-table", driver);
		DynamicTablePage ob=DynamicTablePage.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=DynamicTablePage.class.getDeclaredMethod("getDynamicTable");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Table printed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
