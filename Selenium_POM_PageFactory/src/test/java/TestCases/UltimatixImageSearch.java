package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.UltimatixLoginPage;

public class UltimatixImageSearch extends Baseclass {
	
	@Test
	public void SearchImage()
	{
		UltimatixLoginPage ob=new UltimatixLoginPage(driver);
		ob.FindScrewFixImage();
		
	}

}
