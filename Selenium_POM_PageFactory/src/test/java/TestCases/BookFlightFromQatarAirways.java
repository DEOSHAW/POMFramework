package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.QatarAirways;

public class BookFlightFromQatarAirways extends Baseclass {
	
	
	@Test
	public void BookAFlight() throws InterruptedException
	{
		
		QatarAirways ob=new QatarAirways(driver);
		ob.searchFlight();
		
	}

}
