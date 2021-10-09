package TestCases;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SVG;
import utilities.seleniumUtilities;

public class SVGTest extends Baseclass {
	
	@Test
	void testSVG() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser(System.getProperty("user.dir")+File.separator+"SVG.html", driver);
		SVG ob=SVG.class.getConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		SVG.class.getDeclaredMethod("findRedCircles").invoke(ob);
		
		
	}

}
