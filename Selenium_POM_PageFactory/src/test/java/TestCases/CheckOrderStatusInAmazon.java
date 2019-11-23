package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Amazon;

public class CheckOrderStatusInAmazon extends Baseclass {
	
	@Test
	public void CheckOrderStatus() throws InterruptedException
	{
		Amazon ob=new Amazon(driver);
		ob.LogIntoAmazon();
	}
	

}
