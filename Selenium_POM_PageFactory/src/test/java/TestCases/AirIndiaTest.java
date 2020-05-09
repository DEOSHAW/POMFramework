package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.AirIndia;

public class AirIndiaTest extends Baseclass {
	
	
	@Test
	void AIR_Test() throws InterruptedException, IOException
	{
		AirIndia ob=new AirIndia(driver,test);
		ob.GetTollNumber();
		
	}
	
	

}
