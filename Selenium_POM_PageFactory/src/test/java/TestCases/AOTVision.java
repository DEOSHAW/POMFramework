package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.AOT;

public class AOTVision extends Baseclass {
	
	@Test
	public void getVision()
	{
		AOT ob=new AOT(driver,test);
		ob.GetDetails();
		
	}

}
