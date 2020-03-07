package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.UltimatixRevampedPage;

public class Loginto_Ultimatix extends Baseclass {
	
	@Test
	public void Login() throws InterruptedException
	{
		
		UltimatixRevampedPage ob=new UltimatixRevampedPage(driver);
		ob.LogintoUltimatix();
		
	}

}
