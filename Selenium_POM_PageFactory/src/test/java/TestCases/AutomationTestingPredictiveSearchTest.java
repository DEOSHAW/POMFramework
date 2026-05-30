package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingPredictiveSearch;
import utilities.seleniumUtilities;

public class AutomationTestingPredictiveSearchTest extends Baseclass
{
	@Test
	void selectTextBasedOnPredictiveSearch() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/predictive.html", driver);
		AutomationTestingPredictiveSearch ob=AutomationTestingPredictiveSearch.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingPredictiveSearch.class.getDeclaredMethod("selectCountry", String.class);
		m.setAccessible(true);
		String successMsg=(String) m.invoke(ob, seleniumUtilities.getDataForKey("COUNTRY"));
		System.out.println(successMsg);
		Assert.assertEquals(successMsg, "You selected: India");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");	
	}
}
