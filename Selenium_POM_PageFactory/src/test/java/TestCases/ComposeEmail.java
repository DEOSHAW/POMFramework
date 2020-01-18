package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.gmail;

public class ComposeEmail extends Baseclass {
	
	@Test
	public void ComposeAnEmail() throws InterruptedException
	{
		gmail ob=new gmail(driver);
		ob.ComposeTestEmail();
	}

}
