package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.HDFC;

public class HDFCWindowHandling extends Baseclass {
	
	
	@Test
	void HDFC_Window_Handling() throws InterruptedException
	{
		HDFC ob=new HDFC(driver);
		ob.GetWindows();
		
	}

}
