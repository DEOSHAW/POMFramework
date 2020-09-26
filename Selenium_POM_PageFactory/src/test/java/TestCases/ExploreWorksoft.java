package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Worksoft;
import utilities.seleniumUtilities;

public class ExploreWorksoft extends Baseclass {
	
	@Test
	public void getWorksoftKnowledge()
	{
		seleniumUtilities.LaunchBrowser("https://www.flipkart.com/",driver);
		Worksoft certify=new Worksoft(driver,test);
		certify.getAllProductsByWorksoft();
		
		
	}

}
