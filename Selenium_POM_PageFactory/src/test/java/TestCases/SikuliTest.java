package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.MonsterDotCom;
import utilities.seleniumUtilities;

public class SikuliTest extends Baseclass {
	
	@Test
	void testFileUpload() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.monsterindia.com/seeker/registration",driver);
		MonsterDotCom.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).uploadCV();
		
	}

}
