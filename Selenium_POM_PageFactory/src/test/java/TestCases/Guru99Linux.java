package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Guru99Home;

public class Guru99Linux extends Baseclass {
	
	@Test
	public void GoToLinuxTutorial()
	{
		Guru99Home ob=new Guru99Home(driver);
	    ob.ClickOnLinux();
	}
	

}
