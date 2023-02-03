package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Swagger;
import utilities.seleniumUtilities;

public class SwaggerTest extends Baseclass {
	
	
	
	@Test
	void getSwaggerProTools() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://swagger.io/", driver);
		Swagger ob=Swagger.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Swagger.class.getDeclaredMethod("getProTools");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
		
		
	}

}
