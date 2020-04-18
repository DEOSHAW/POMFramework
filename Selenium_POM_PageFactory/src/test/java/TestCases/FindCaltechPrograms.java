package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Caltech;

public class FindCaltechPrograms extends Baseclass {
	
	
	@Test
	public void SearchPrograms()
	{
		
		Caltech ob=new Caltech(driver);
		ob.FindGradPrograms();
		
	}

}
