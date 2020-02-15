package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.PGATour;

public class Search_Tiger_In_Leaderboard extends Baseclass {
	
	@Test
	public void SearchTiger() throws InterruptedException 
	{
		
		PGATour ob=new PGATour(driver);
		ob.SearchTigerWoods();
		
	 }
	
	
	
	
	
	

}
