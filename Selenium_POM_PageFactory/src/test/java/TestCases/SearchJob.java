package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.MonsterIndia;

public class SearchJob extends Baseclass {

   @Test
	void FindJob() throws InterruptedException
	{
	   
	   MonsterIndia ob=new MonsterIndia(driver);
	   
	   ob.LookForJob();
		
	}

}
