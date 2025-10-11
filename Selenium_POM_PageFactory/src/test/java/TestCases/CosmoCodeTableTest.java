package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.CosmoCodeTable;
import utilities.seleniumUtilities;

public class CosmoCodeTableTest extends Baseclass
{
	@Test
	void selectCountryInTable() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://cosmocode.io/automation-practice-webtable/", driver);
		CosmoCodeTable ob=CosmoCodeTable.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=CosmoCodeTable.class.getDeclaredMethod("selectCountry", String.class);
		m.setAccessible(true);
		m.invoke(ob,seleniumUtilities.getDataForKey("COUNTRY"));
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Country checkbox selected");
		test.log(LogStatus.PASS, "Test Ended");	
	}
}
