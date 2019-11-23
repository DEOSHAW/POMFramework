package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Guru99WebTable;

public class WebTableHandling extends Baseclass {
	
	@Test
	public void TableHandling()
	{
		
		Guru99WebTable ob=new Guru99WebTable(driver);
		//ob.PrintTableValues();
		//double Sum=ob.PrintTotal();
		//System.out.println("Total sum is "+Sum);
		double LowestValue=ob.LowestTableValue();
		System.out.println("Lowest Value is"+LowestValue);
		
	}
	
	

}
