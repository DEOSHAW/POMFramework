package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Guru99Alert;
import utilities.seleniumUtilities;

public class AlertTest extends Baseclass {
	
  
	
	@Test
	public void CheckAlertFunctions() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://demo.guru99.com/test/delete_customer.php",driver);
		Guru99Alert ob=new Guru99Alert(driver,test);
		ob.AlertFunctionTest();
	}

}
