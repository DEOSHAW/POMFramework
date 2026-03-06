package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IBSF;
import utilities.seleniumUtilities;

public class IBSFTest extends Baseclass
{
	@Test
	void validateTheMenuText() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.ibsf.org/en/", driver);
		IBSF ob=IBSF.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IBSF.class.getDeclaredMethod("getTheMenuText", String.class);
		m.setAccessible(true);
		String text="Athletes";
		String menuText=(String) m.invoke(ob, text);
		Assert.assertEquals(menuText, text.toUpperCase());
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
