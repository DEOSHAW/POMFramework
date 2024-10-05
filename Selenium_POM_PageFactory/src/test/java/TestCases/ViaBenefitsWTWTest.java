package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.ViaBenefitsWTW;
import utilities.seleniumUtilities;

public class ViaBenefitsWTWTest extends Baseclass {
	
	
	
	@Test
	void getViaBenefitsAdvantages() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://optimizeretireebenefits.com/", driver);
		ViaBenefitsWTW ob=ViaBenefitsWTW.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ViaBenefitsWTW.class.getDeclaredMethod("getBenefitsForRetirees");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
