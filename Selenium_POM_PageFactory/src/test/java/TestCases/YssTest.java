package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.YSS;
import utilities.seleniumUtilities;

public class YssTest extends Baseclass
{
	@Test
	void validateLanguageOptions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://yssofindia.org/", driver);
		YSS ob=YSS.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=YSS.class.getDeclaredMethod("getLanguageOptions");
		m.setAccessible(true);
		List<String> langList=(List<String>) m.invoke(ob);
		Assert.assertEquals(langList.get(3), "தமிழ்");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
