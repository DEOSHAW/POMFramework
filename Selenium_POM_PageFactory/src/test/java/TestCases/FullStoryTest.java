package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FullStory;
import utilities.seleniumUtilities;

public class FullStoryTest extends Baseclass
{
	
	
	@Test
	void getFullStoryStatementOfInclusion() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.fullstory.com/", driver);
		FullStory ob=FullStory.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FullStory.class.getDeclaredMethod("getStatementOfInclusion");
		m.setAccessible(true);
		String inclusionStatement=(String) m.invoke(ob);
		Assert.assertTrue(inclusionStatement.contains("At Fullstory, we are focused on creating an environment "));
		test.log(LogStatus.PASS, "Statement of inclusion asserted");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
