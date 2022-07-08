package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.UBC;
import utilities.seleniumUtilities;

public class UBC_Test extends Baseclass {
	
	
	@Test
	void getListOfGraduateProgramsAtUBC() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.ubc.ca/", driver);
		UBC ob=UBC.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UBC.class.getDeclaredMethod("getListOfGraduatePrograms");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
