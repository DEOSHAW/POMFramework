package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Caltech;
import utilities.seleniumUtilities;

public class FindCaltechPrograms extends Baseclass {
	
	
	@Test
	public void SearchPrograms()
	{
		seleniumUtilities util=new seleniumUtilities(driver);
		util.LaunchBrowser("https://www.caltech.edu/");
		Caltech ob=new Caltech(driver);
		ob.FindGradPrograms();
		util.closeBrowser();
		
	}

}
