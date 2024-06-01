package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Mahindra;
import utilities.seleniumUtilities;

public class MahindraTest extends Baseclass
{
	
	
	@Test
	void getMahindraGroupBusinessVerticals() throws Exception
	{
		
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.mahindra.com/", driver);
		Mahindra ob=Mahindra.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Mahindra.class.getDeclaredMethod("getBusinessVerticals");
		m.setAccessible(true);
		List<String> businessVerticals=(List<String>) m.invoke(ob);
		System.out.println(businessVerticals);
		Assert.assertEquals(businessVerticals.get(3).trim(), "FINANCIAL SERVICES");
		test.log(LogStatus.PASS, "List of business verticals fetched");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
