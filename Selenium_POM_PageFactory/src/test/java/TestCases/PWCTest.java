package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.PWC;
import utilities.seleniumUtilities;

public class PWCTest extends Baseclass {
	
	@Test
	void ExploreCareerAtPWC() throws InterruptedException
	{
		seleniumUtilities.LaunchBrowser("https://www.pwc.in/", driver);
		PWC ob=new PWC(driver,test);
		ob.ExploreCareerBenefitsAtPWC();
		
	}

}
