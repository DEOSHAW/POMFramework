package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Worksoft;
import utilities.seleniumUtilities;

public class ExploreWorksoft extends Baseclass {
	
	@Test
	public void getWorksoftKnowledge()
	{
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://www.worksoft.com/");
		Worksoft certify=new Worksoft(driver,test);
		certify.getAllProductsByWorksoft();
		ob.closeBrowser();
		
	}

}
