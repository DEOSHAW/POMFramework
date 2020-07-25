package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.BarCodeGenerator;
import utilities.seleniumUtilities;

public class BarCodeAutomation extends Baseclass {
	
	@Test
	public void getBarCodeDetails() throws Exception
	{
		
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://testautomationpractice.blogspot.com/");
		BarCodeGenerator generator=new BarCodeGenerator(driver,test);
		generator.createAndValidateBarCode();
		ob.closeBrowser();
		
	}

}
