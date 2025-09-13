package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Tosca;
import utilities.seleniumUtilities;

public class ToscaTest extends Baseclass
{
	@Test
	void validateToscaTools() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tricentis.com/products/automate-continuous-testing-tosca", driver);
		Tosca ob=Tosca.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Tosca.class.getDeclaredMethod("getToscaTitle");
		m.setAccessible(true);
		String pageTitle=(String)m.invoke(ob);
		Assert.assertEquals(pageTitle,"Tricentis Tosca – Accelerate & Automate Continuous Testing | Tricentis");
		test.log(LogStatus.PASS, "Validation Successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
