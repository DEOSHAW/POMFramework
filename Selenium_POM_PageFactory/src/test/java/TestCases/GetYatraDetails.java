package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.VaishnoDevi;
import utilities.seleniumUtilities;

public class GetYatraDetails extends Baseclass{
	
	
	
	@Test
	void GetYatraInfo()
	{
		
		seleniumUtilities.LaunchBrowser("https://www.maavaishnodevi.org/",driver);
		VaishnoDevi ob1=new VaishnoDevi(driver,test);
		ob1.getDetails();
		
		
	}
	
	

}
