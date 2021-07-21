package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Youtube;
import utilities.seleniumUtilities;

public class YoutubeTest extends Baseclass {
	
	@Test
	void getVideosList() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.youtube.com/", driver);
		Youtube ob=Youtube.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Youtube.class.getMethod("getVideoTitles").invoke(ob);
		
		
	}

}
