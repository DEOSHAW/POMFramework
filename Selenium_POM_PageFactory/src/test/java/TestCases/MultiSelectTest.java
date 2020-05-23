package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SeleniumEasy;

public class MultiSelectTest extends Baseclass {
	
	@Test
	public void SelectMultipleOptions()
	{
		SeleniumEasy ob=new SeleniumEasy(driver,test);
		ob.selectValuesFromDropdown();
	}

}
