package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.ATPTour;

public class Search_Federer_Ranking extends Baseclass {
	
	@Test
	public void SearchRanking()
	{
		
		ATPTour ob =new ATPTour(driver);
		ob.SearchForRankings();
		
	}

}
