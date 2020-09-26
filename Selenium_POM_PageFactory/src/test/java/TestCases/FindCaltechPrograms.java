package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Caltech;
import utilities.seleniumUtilities;

public class FindCaltechPrograms extends Baseclass {
	
	
	@Test
	public void SearchPrograms()
	{
		seleniumUtilities.LaunchBrowser("https://www.caltech.edu/",driver);
		Caltech ob=new Caltech(driver);
		ob.FindGradPrograms();
		
		
	}

}
