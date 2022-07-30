package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.OracleApexLogin;
import utilities.seleniumUtilities;

public class OracleApexLoginTest extends Baseclass {
	
	
	
	@Test(dataProvider = "DataSupplierWithPoi")
	void testLogin(String Wk,String user,String pwd) throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://apex.oracle.com/", driver);
		OracleApexLogin ob=OracleApexLogin.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=OracleApexLogin.class.getDeclaredMethod("Login",String.class,String.class,String.class);
		m.setAccessible(true);
		m.invoke(ob,Wk,user,pwd);
		
		
	}

}
