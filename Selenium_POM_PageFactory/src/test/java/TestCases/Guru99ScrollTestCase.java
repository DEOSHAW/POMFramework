package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Guru99ScrollWebPage;

public class Guru99ScrollTestCase extends Baseclass {
	
	@Test
	public void ScrollPage()
	{
	
	Guru99ScrollWebPage ob=new Guru99ScrollWebPage(driver);
	ob.ScrollWebPage();
	
	
	

     }
}
