package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.CosmoCode;
import utilities.seleniumUtilities;

public class CosmoCodeTest extends Baseclass
{
	
	@Test
	void getRecordsFromCosmoCodeWebTable() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://cosmocode.io/automation-practice-webtable/", driver);
		CosmoCode ob=CosmoCode.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=CosmoCode.class.getDeclaredMethod("getRecordsFromWebTable");
		m.setAccessible(true);
		List<String> allRecords=(List<String>) m.invoke(ob);
		test.log(LogStatus.PASS, "Retrieved All records");
		for(String eachRecord:allRecords)
		{
			if(eachRecord.contains("India"))
			{
				Assert.assertTrue(eachRecord.contains("New Delhi"));
			}
		}
		test.log(LogStatus.PASS, "Table contains New Delhi");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
	}

}
