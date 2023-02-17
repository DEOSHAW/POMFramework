package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Terraform;
import utilities.seleniumUtilities;

public class TerraformTest extends Baseclass {
	
	
	@Test
	void getTerraformUseCases() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.terraform.io/",driver);
		Terraform ob=Terraform.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Terraform.class.getDeclaredMethod("getUseCases");
		m.setAccessible(true);
		m.invoke(ob);
		
	}

}
