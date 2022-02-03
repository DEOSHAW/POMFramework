package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.SAS_INC;
import utilities.seleniumUtilities;

public class SAS_INC_TEST extends Baseclass {
	
	
	@Test(priority = -1)
	void testSASSolutionForBanks() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.sas.com/en_in/home.html", driver);
		Class clazz=SAS_INC.class;
		SAS_INC ob=SAS_INC.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=clazz.getDeclaredMethod("getSASBankingSolutions");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
