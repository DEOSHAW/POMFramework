package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Guru99Alert;

public class AlertTest extends Baseclass {
	
  
	
	@Test
	public void CheckAlertFunctions() throws Exception
	{
		Guru99Alert ob=new Guru99Alert(driver);
		ob.AlertFunctionTest();
	}

}
