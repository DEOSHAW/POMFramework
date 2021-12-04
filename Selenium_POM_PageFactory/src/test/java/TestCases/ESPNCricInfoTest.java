package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ESPNCricInfo;
import utilities.seleniumUtilities;

public class ESPNCricInfoTest extends Baseclass {
	
	@Test
	void findTopRunGettersForIndiaInTestMatches() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://stats.espncricinfo.com/Ci/content/records/223646.html", driver);
		ESPNCricInfo ob=ESPNCricInfo.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ESPNCricInfo.class.getDeclaredMethod("getTopRunGetters");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
