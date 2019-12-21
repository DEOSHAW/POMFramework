package TestCases;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.MercuryTours;
public class VerifyTextOnMercuryTourPage extends Baseclass {
	
	@Test
	void findText()
	{
		
		MercuryTours ob=new MercuryTours(driver);
		ob.ExtractText();
		
	}
	
	

}
