package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingAccordion;
import utilities.seleniumUtilities;

public class AutomationTestingAccordionTest extends Baseclass
{
	@Test
	void validateAccordian() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/accordion.html", driver);
		AutomationTestingAccordion ob=AutomationTestingAccordion.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingAccordion.class.getDeclaredMethod("getAccordianText");
		m.setAccessible(true);
		String accordionText=(String) m.invoke(ob);
		Assert.assertTrue(accordionText.contains("Selenium is a highly portable tool"), "Accordion Text is not correct!");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");	
	}
}
