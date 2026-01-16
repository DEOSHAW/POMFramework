package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuAppFrames;
import utilities.seleniumUtilities;

public class HerokuAppFramesTest extends Baseclass
{
	@Test
	void validateMiddleFrameTexts() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://testpages.herokuapp.com/pages/embedded-pages/frames/?utm_source=chatgpt.com", driver);
		HerokuAppFrames ob=HerokuAppFrames.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuAppFrames.class.getDeclaredMethod("getMiddleFrameTexts");
		m.setAccessible(true);
		List<String> middleSectionTexts=(List<String>) m.invoke(ob);
		Assert.assertEquals(middleSectionTexts.size(), 40,"Item count did not match");
		Assert.assertEquals(middleSectionTexts.get(3), "Middle List Item 3","Item did not match");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
