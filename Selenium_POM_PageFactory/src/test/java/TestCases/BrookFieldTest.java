package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.BrookField;
import utilities.seleniumUtilities;

public class BrookFieldTest extends Baseclass
{
	@Test
	void ValidateAboutUs() throws Exception
	{
		test.log(LogStatus.PASS,"Test Started");
		seleniumUtilities.LaunchBrowser("https://www.brookfield.com/", driver);
		BrookField ob=BrookField.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=BrookField.class.getDeclaredMethod("getAboutUs");
		m.setAccessible(true);
		String aboutUsText=(String) m.invoke(ob);
		Assert.assertEquals(aboutUsText,"As a leading global investment firm, we apply our owner-operator mindset to manage and grow the businesses we own on behalf of our clients." );
		test.log(LogStatus.PASS,"Validation successful");
		test.log(LogStatus.PASS,"Test Ended");
		
	}

}
