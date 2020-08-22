package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.phpTravels;
import utilities.seleniumUtilities;

public class PickCalendarDate extends Baseclass {
	
	
	@Test
	public void pickPartcularDate() throws InterruptedException
	{
		
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://phptravels.net/");
		phpTravels travel=new phpTravels(driver,test);
		travel.selectCheckInDate("November", "8");
		travel.selectCheckOutDate("November", "12");
		ob.closeBrowser();
		
	}

}
