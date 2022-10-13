package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UITestingPlayground_DynamicTable;
import utilities.seleniumUtilities;

public class UITestingPlayground_DynamicTable_Test extends Baseclass {
	
	
	@Test
	void getCPUData() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("http://uitestingplayground.com/dynamictable", driver);
		UITestingPlayground_DynamicTable ob=UITestingPlayground_DynamicTable.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UITestingPlayground_DynamicTable.class.getDeclaredMethod("getValueOfCpuLoadFromTable");
		m.setAccessible(true);
		String cpuLoadForChromeFromTable=(String) m.invoke(ob);
		String displayedCpuLoad=ob.getDisplayedValueOfCpuLoad();
		Assert.assertEquals(displayedCpuLoad, cpuLoadForChromeFromTable);
		test.log(LogStatus.PASS, "CPU load for chrome is same");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
