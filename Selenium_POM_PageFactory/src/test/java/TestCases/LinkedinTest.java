package TestCases;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Linkedin;

public class LinkedinTest extends Baseclass {
	
	@Test
	void getProfileDetails()
	{
		Linkedin ob=new Linkedin(driver,test);
		ob.searchProfile();
		
	}
	

}
