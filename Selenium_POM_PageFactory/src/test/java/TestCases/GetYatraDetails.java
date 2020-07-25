package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.VaishnoDevi;
import utilities.seleniumUtilities;

public class GetYatraDetails extends Baseclass{
	
	
	
	@Test
	void GetYatraInfo()
	{
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://www.maavaishnodevi.org/");
		VaishnoDevi ob1=new VaishnoDevi(driver,test);
		ob1.getDetails();
		ob.closeBrowser();
		
	}
	
	

}
