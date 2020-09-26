package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SeleniumEasy;
import utilities.seleniumUtilities;

public class JavascriptAlertHandling extends Baseclass {
	
	@Test
	public void HandleAlert() throws InterruptedException
	{
	
		seleniumUtilities.LaunchBrowser("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html",driver);
		SeleniumEasy ob=new SeleniumEasy(driver,test);
		ob.HandleAlert();

		
	}

}
