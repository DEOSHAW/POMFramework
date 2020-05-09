package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.AutomationTesting;

public class AutomationTestingWebTable extends Baseclass {
	
	@Test
	public void EditDetailsInTheTable()
	{
		
		AutomationTesting ob=new AutomationTesting(driver,test);
		ob.EditDetails();
		
	}

}
