package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.NaukriDotComPage;

public class NaukriDotCom extends Baseclass {
	
	
	
	@Test
	void NaukriWindowHandling() throws Throwable
	{
	   NaukriDotComPage ob=new NaukriDotComPage(driver);
	   ob.FindWindowsOnNaukriPage();
		
		
	}

}
