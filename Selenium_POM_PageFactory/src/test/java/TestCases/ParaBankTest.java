package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.ParaBank;
import utilities.seleniumUtilities;

public class ParaBankTest extends Baseclass
{
	@Test
	void navigateToParaBankServicesPage() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://parabank.parasoft.com/parabank/index.htm", driver);
		ParaBank ob=ParaBank.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=ParaBank.class.getDeclaredMethod("navigateToServices");
		m.setAccessible(true);
		List<String> services=(List<String>) m.invoke(ob);
		Assert.assertEquals(services.size(), 5, "Count of services not correct");
		Assert.assertEquals(services.get(3), "ParaBank services:");
		test.log(LogStatus.PASS, "Services validated successfully", "Service name is not correct");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
