package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.LearnAutomation;

public class GetPageSource extends Baseclass {
	
	@Test
	public void FindPageSource()
	{
		
		LearnAutomation ob=new LearnAutomation(driver);
		ob.FindPageSource();
		
	}

}
