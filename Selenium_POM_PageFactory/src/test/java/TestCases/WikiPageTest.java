package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.WikiPage;
import utilities.seleniumUtilities;

public class WikiPageTest extends Baseclass {
	
	@Test
	void wikiTest() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://en.wikipedia.org/wiki/Main_Page", driver);
		WikiPage.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).searchTopics();
		
	}

}
