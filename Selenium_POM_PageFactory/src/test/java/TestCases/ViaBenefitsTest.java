package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ViaBenefits;
import utilities.seleniumUtilities;

public class ViaBenefitsTest extends Baseclass {
	
	
	
	@Test
	void getViaBenefitsAdvantages() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://optimizeretireebenefits.com/", driver);
		ViaBenefits ob=ViaBenefits.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ViaBenefits.class.getDeclaredMethod("getBenefitsForRetirees");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
