package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.GoogleHomePage;

public class GoogleAutoSuggestiveDropdown extends Baseclass {

	@Test
	void Google() throws InterruptedException
	{
		
		GoogleHomePage ob=new GoogleHomePage(driver);
		ob.SearchForContent();
		
	}
}
