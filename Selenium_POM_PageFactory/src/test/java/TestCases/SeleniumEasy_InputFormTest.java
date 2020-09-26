package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SeleniumEasy;
import utilities.seleniumUtilities;

public class SeleniumEasy_InputFormTest extends Baseclass {
	
	@Test
	void RegisterNewCustomer()
	{
	
		seleniumUtilities.LaunchBrowser("https://www.seleniumeasy.com/test/input-form-demo.html",driver);
		SeleniumEasy ob=new SeleniumEasy(driver,test);
		ob.FillDataInForm();

	}

}
