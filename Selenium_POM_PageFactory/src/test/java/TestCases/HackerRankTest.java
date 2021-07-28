package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.HackerRank;
import utilities.seleniumUtilities;

public class HackerRankTest extends Baseclass {
	
	
	
	@Test
	void testHackerRank() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.hackerrank.com/", driver);
		HackerRank.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).getRecruitersList();
		
		
	}

}
