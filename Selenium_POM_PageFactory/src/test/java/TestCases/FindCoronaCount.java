package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.CoronaWorldmeter;

public class FindCoronaCount extends Baseclass {
	
	@Test
	public void FindCount()
	{
		CoronaWorldmeter ob=new CoronaWorldmeter(driver);
		ob.PrintCount();
		ob.FindIndiaCount();
		
	}

}
