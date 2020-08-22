package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.GitHub;
import utilities.seleniumUtilities;

public class GitHubTest extends Baseclass {
	
	@Test
	public void GitHubRepositoryTest() throws InterruptedException
	{
		
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://github.com/");
		GitHub profile=new GitHub(driver,test);
		profile.getRepositoryCount();
		ob.closeBrowser();
		
	}

}
