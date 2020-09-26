package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Flipkart;
import utilities.seleniumUtilities;

public class CarouselTest extends Baseclass {
	
	
	@Test
	public void testCarousel() throws InterruptedException
	{
		
		seleniumUtilities.LaunchBrowser("https://www.flipkart.com/",driver);
		Flipkart flip=new Flipkart(driver,test);
		flip.ValidateAppliances();
		
		
	}

}
