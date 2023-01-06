package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Quess;
import utilities.seleniumUtilities;

public class QuessTest extends Baseclass {
	
	@Test
	void getQuessDomesticITServicesInformation() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.quesscorp.com/", driver);
		Quess ob=Quess.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Quess.class.getDeclaredMethod("getInformationOnDomesticITServices");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
