package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.AirBnb;

public class CheckAssert extends Baseclass {
	
	
	
	@Test
	public void SearchHotelsInAirBnb() throws InterruptedException
	{
		AirBnb ob=new AirBnb(driver);
		ob.SearchForHotels();
		
		
		
		
	}

}
